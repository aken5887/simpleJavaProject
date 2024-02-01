package org.backjun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 15649번 N과 M(1)
 * 백트래킹 알고리즘을 DFS로 푸는 것이 핵심이다.
 */
public class Boj_15649_NM1 {
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N]; // 1~N까지 숫자 방문여부
        arr = new int[M]; // 결과
        dfs(0, N, M);
    }

    private static void dfs(int depth, int N, int M){
        if(depth == M){ // 깊이 탐색 종료 조건
            for(int num:arr){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){ // 만약 해당 노드를 방문하지 않았다면
                visited[i] = true; // 방문처리 하고
                arr[depth] = i+1; // 해당 차례에 i+1 값 저장
                dfs(depth+1, N, M); // 다음 자식 노드 방문, 재귀호출
                visited[i] = false; // 자식노드 방문 종료 후 방문 노드를 방문하지 않은 상태로 변경
            }
        }
    }
}
