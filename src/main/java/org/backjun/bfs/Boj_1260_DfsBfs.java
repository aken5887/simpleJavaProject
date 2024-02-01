package org.backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  1260번 DFS와 BFS
 *
    Input
     4 5 1
     1 2
     1 3
     1 4
     2 4
     3 4

    Output
     1 2 4 3
     1 2 3 4
 */
public class Boj_1260_DfsBfs {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int N;   // 정점의 개수
    static int M;   // 간선의 개수
    static int V;   // 탐색을 시작할 정점 번호

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        // list 배열 초기화
        for(int i=1; i<= N; i++){
            arr[i] = new ArrayList<>();
        }

        // 그래프 구현
        for(int j=0; j<M; j++){
            st = new StringTokenizer(bf.readLine(), " ");
            int root = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            arr[root].add(next);
            arr[next].add(root); // 양방향 연결
        }

        // 오름차순 정렬
        for(int k=1; k<= N; k++){
            Collections.sort(arr[k]);
        }

        dfs(V);
        System.out.println();
        bfs(V);
    }

    /**
     * 1 - 2  - 4 | 3
     * @param node
     */
    private static void dfs(int node){
        if(!visited[node]){
            visited[node] = true;
            System.out.print(node + " ");
            for(int e:arr[node]){
                if(!visited[e]){
                    dfs(e);
                }
            }
        }
    }

    private static void bfs(int node){
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[N+1];
        visited[node] = true;
        que.offer(node);

        while(!que.isEmpty()){
            int current = que.poll();
            System.out.print(current+" ");
            for(int e:arr[current]){
                if(!visited[e]){
                    visited[e] = true;
                    que.offer(e);
                }
            }
        }
    }
}