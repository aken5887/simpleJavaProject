package org.backjun.bfs.review;

import org.backjun.MyBufferedReader;

import java.io.BufferedReader;
import java.util.*;

/**
 * packageName    : org.backjun.bfs.retry
 * fileName       : Boj_1260_DfsBfs_Retry2
 * author         : choi
 * date           : 2/2/24
 */
public class Boj_1260_DfsBfs_Review2 {
    private static int N;   // 노드의 개수
    private static int M;   // 간선의 개수
    private static int V;   // 시작점

    private static boolean[] visited; // 방문 배열

    private static ArrayList<Integer>[] arr;    // 그래프 노드 배열

    public static void main(String[] args) {
        BufferedReader bf = MyBufferedReader.getInstance();
        StringTokenizer st = MyBufferedReader.getTokenizer(" ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        // List 초기화
        for(int i=0; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = MyBufferedReader.getTokenizer(" ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            arr[parent].add(child);
            arr[child].add(parent);
        }
        // 숫자가 작은 수부터 방문해야 하기 때문에 인접 리스트 정렬
        for(int i=0; i<arr.length; i++){
            Collections.sort(arr[i]);
        }
        dfs(V);
        System.out.println();
        bfs(V);
    }

    private static void dfs(int node){
        if(!visited[node]){
            visited[node] = true; // 해당 노드 방문 처리
            System.out.print(node+" ");
            // 해당 노드 인접 노드 탐방
            for(int child:arr[node]){
                if(!visited[child]) dfs(child);
            }
        }
    }

    private static void bfs(int node){
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[N+1];

        que.offer(node);
        visited[node] = true;

        while(!que.isEmpty()){
            int parent = que.poll();
            System.out.print(parent+" ");
            for(int child:arr[parent]){
                if(!visited[child]) {
                    visited[child] = true;
                    que.offer(child);
                }
            }
        }
    }

}
