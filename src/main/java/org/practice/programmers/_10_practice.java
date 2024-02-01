package org.practice.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class _10_practice {
    public static void main(String[] args) {
        _10_practice p = new _10_practice();
        int[][] wires = new int[8][2];
        wires[0] = new int[]{1, 3};
        wires[1] = new int[]{2, 3};
        wires[2] = new int[]{3, 4};
        wires[3] = new int[]{4, 5};
        wires[4] = new int[]{4, 6};
        wires[5] = new int[]{4, 7};
        wires[6] = new int[]{7, 8};
        wires[7] = new int[]{7, 9};
        p.solution(9, wires);
    }
    List<Integer>[] list;
    public int solution(int n, int[][] wires) {
        int answer = 100;
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        // 양방향 연결
        for(int i=0; i<wires.length; i++){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }

        // 연결을 하나씩 끊기
        for(int i=0; i<wires.length; i++){
            int n1 = bfs(wires[i][0], wires[i][1], n);
            int n2 = bfs(wires[i][1], wires[i][0], n);
            answer = Math.min(answer, Math.abs(n1-n2));
        }
        return answer;
    }

    int bfs(int v1, int v2, int n){
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        int count = 0;
        que.add(v1);
        visited[v1] = true;

        while(!que.isEmpty()){
            int current = que.poll();
            count++;
            for(int next:list[current]){
                if(!visited[next] && next != v2){
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
        return count;
    }
}
