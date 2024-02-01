package org.backjun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15652번
 * 1 <= M <= N <= 8
 */
public class Boj_15652_NM4 {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(0);
    }

    public static void dfs(int depth){
        if(depth == M){
            for(int number:arr){
                System.out.print(number+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(depth > 0 && arr[depth-1] > i) continue;
            arr[depth] = i;
            dfs(depth+1);
        }
    }
}
