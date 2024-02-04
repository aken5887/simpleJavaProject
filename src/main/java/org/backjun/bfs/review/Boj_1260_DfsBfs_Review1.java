package org.backjun.bfs.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1260_DfsBfs_Review1 {

    static int N;   // 노드의 수
    static int M;   // 간선의 개수
    static int V;   // 탐색 시작 점
    static boolean[] visited;  // 방문 여부 저장
    static ArrayList<Integer>[] arr; // 노드를 저장하는 배열, 각 노드는 list에 인접한 노드 정보가 포함되어 있음

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        // 배열 내 리스트 초기화
        for(int i=0; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        visited = new boolean[N+1];
        // 트리 생략
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            arr[parent].add(child);
            arr[child].add(parent);
        }
        // 오름차순 정렬을 왜 할까?
        // 정점이 여러개인 경우 번호가 작은순으로 방문해야 하기 떄
        for(int i=1; i<=N; i++){
            Collections.sort(arr[i]);
        }
        dfs(V);
        System.out.println();
        bfs(V);
    }

    private static void dfs(int node){
        if(!visited[node]){
            visited[node] = true; // 방문처리
            System.out.print(node+" ");
            for(int child: arr[node]){ // 해당 노드에 인접한 노드 방문
                if(!visited[child]){
                    dfs(child);
                }
            }
        }
    }

    private static void bfs(int node){
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[N+1];
        que.offer(node);
        visited[node] = true;
        while(!que.isEmpty()){
            int current = que.poll();
            System.out.print(current+" ");
            for(int child:arr[current]){
                if(!visited[child]){
                    visited[child] = true;
                    que.offer(child);
                }
            }
        }
    }
}
