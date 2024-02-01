package org.backjun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 14888 연산자 끼워넣기
 */
public class Boj_14888_InsertOperator {
    static int N;
    static int[] arr;
    static int[] operator;
    static boolean[] visited;
    static int[] op;

    static int MAX = Integer.MIN_VALUE;

    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        operator = new int[N-1];
        visited = new boolean[N-1];
        op = new int[N-1];
        int idx = 0;
        for(int j=0; j<4; j++){
            int op = Integer.parseInt(st.nextToken());
            for(int i=0; i<op; i++){
              operator[idx++] = j;
            }
        }
        dfs(0);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int depth){
        // 주어진 수의 순서는 바뀌지 않는다.
        if(depth == N-1){
            updateMaxMin();
            return;
        }

        for(int i=0; i< operator.length; i++){
            if(!visited[i]){
                visited[i] = true;
                op[depth] = operator[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void updateMaxMin(){
        // arr, op
        int temp = arr[0];
        for(int i=1; i<arr.length; i++){
            int num = arr[i];
            switch(op[i-1]){
                case 0:
                    temp = temp + num;
                    break;
                case 1:
                    temp = temp - num;
                    break;
                case 2:
                    temp = temp * num;
                    break;
                case 3:
                    temp = temp / num;
                    break;
            }
        }
        MAX = Math.max(MAX, temp);
        MIN = Math.min(MIN, temp);
    }
}
