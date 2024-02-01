package org.backjun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14888번 연산자 끼워넣기
 * 좀 더 간결하고 dfs를 활용한 버전 - 시간 80% 감소
 */
public class Boj_14888_InsertOperator2 {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] numbers;                   // 숫자 집합
    static int[] operator = new int[4];     // 연산자의 개수
    static int N;                           // 숫자의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        numbers = new int[N];
        // 숫자 읿력
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for(int i=0; i<numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        // 연산자 입력
        st = new StringTokenizer(bf.readLine(), " ");
        for(int i=0; i<operator.length; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(numbers[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int number, int depth){
        if(depth == N){
            MAX = Math.max(number, MAX);
            MIN = Math.min(number, MIN);
            return;
        }

        for(int i=0; i<4 ; i++){
            if(operator[i] > 0){
                operator[i]--; // 연산자를 하나 감소시킨다.
                switch(i){
                    case 0: dfs(number + numbers[depth], depth+1); break;
                    case 1: dfs(number - numbers[depth], depth+1); break;
                    case 2: dfs(number * numbers[depth], depth+1); break;
                    case 3: dfs(number / numbers[depth], depth+1); break;
                }
                // 재귀호출이 종료 되면 다시 해당 연산자의 개수를 복구
                operator[i]++;
            }
        }
    }
}
