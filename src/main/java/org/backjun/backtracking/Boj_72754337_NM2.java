package org.backjun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 - 72754337번 N과 M(2)
 */
public class Boj_72754337_NM2 {

    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(0, 1);
    }

    public static void dfs(int depth, int at) {
        if(depth == M){
            // 깊이가 M과 같을 경우 출력
            for(int number:arr){
                System.out.print(number+" ");
            }
            System.out.println();
            return;
        }

        // i는 at 부터 탐색하도록 한다 (오름차순 출력)
        for(int i=at; i<=N; i++){
            // 현재 깊이를 index로 하여 해당 위치에 i 값을 담는다.
            arr[depth] = i;
            // 재귀 호출
            dfs(depth+1, i+1);
        }
    }
}
