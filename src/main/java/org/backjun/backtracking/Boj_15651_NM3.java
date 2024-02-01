package org.backjun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15651번 N과 M
 * 모두 출력
 *
 * 시간 제한 1초
 * 1<=M<=N<=7
 */
public class Boj_15651_NM3 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        sb = new StringBuilder();
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth){
        if(M == depth) {    // 종료조건
            for(int a:arr){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            arr[depth] = i;
            dfs(depth+1);
        }
    }
}
