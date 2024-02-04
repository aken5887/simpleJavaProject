package org.backjun.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 11724번 연결 요소의 개수
 * author         : choi
 * date           : 2024-02-02
 */
public class Boj_11724_ConnectedComponent {

    private static int N;  // 정점의 수
    private static int M;  // 간선의 수
    private static boolean[] visited;      // 방문 여부
    private static ArrayList<Integer>[] arr; // 그래프 노드

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            arr[parent].add(child);
            arr[child].add(parent);
        }

        int count = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int node){
        if(!visited[node]){
            visited[node] = true;
            for(int child:arr[node]){
                if(!visited[child]){
                    dfs(child);
                }
            }
        }
    }
}
