package org.backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2606번 바이러스
 * 현재 노드와 연결된 노드 검색
 * author         : choi
 * date           : 2024-02-02
 */
public class Boj_2606_Virus {
    private static int N; // 컴퓨터의 수
    private static int M; // 컴퓨터의 간선 수
    private static boolean[] visited;

    private static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        visited = new boolean[N+1];
        arr = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            arr[parent].add(child);
            arr[child].add(parent);
        }
        System.out.println(bfs(1));
    }


    private static int bfs(int node){
        int count = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(node);
        visited[node] = true;

        while(!que.isEmpty()){
            int current = que.poll();
            for(int child:arr[current]){
                if(!visited[child]){
                    visited[child] = true;
                    que.offer(child);
                    count++;
                }
            }
        }
        return count;
    }
}
