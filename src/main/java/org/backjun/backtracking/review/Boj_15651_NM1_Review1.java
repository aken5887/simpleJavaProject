package org.backjun.backtracking.review;

import org.backjun.MyBufferedReader;

import java.util.StringTokenizer;

public class Boj_15651_NM1_Review1 {
    private static int N; // 자연수 범위 N
    private static int M; // 길이 M
    private static int[] numbers; // 결과 값 저장 (길이 M)
    private static boolean[] visited; // 방문 여부
    public static void main(String[] args) {
        StringTokenizer st = MyBufferedReader.getTokenizer(" ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];
        visited = new boolean[N];
        dfs(0);
    }

    private static void dfs(int depth){
        if(depth == M){
            for(int num: numbers){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                // 방문한 적이 없는 곳 이라면
                visited[i] = true;
                numbers[depth] = i+1;
                dfs(depth+1); // 해당 노드 완전 깊이 탐색
                visited[i] = false; // DFS가 끝난후 다시 원복
            }
        }
    }
}
