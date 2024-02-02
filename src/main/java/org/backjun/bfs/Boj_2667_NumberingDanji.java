package org.backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2667 단지 번호 붙이기
 * author         : choi
 * date           : 2024-02-02
 */
public class Boj_2667_NumberingDanji {
    private static int N;
    private static int[][] houses;

    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0,0,-1,1};

    private static List<Integer> groups = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            char[] lines = bf.readLine().toCharArray();
            for(int j=0; j< lines.length; j++){
                houses[i][j] = lines[j] - '0';
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && houses[i][j] == 1){
                    bfs(new int[]{i,j});
                }
            }
        }
        System.out.println(groups.size());
        Collections.sort(groups);
        for(int group:groups){
            System.out.println(group);
        }
    }

    private static void bfs(int[] start){
        Queue<int[]> que = new LinkedList<>();
        que.offer(start);
        visited[start[0]][start[1]] = true;
        int group = 1;

        while(!que.isEmpty()){
            int[] current = que.poll();
            int x = current[0];
            int y = current[1];
            for(int i=0; i<4; i++){
                int row =  x + dx[i];
                int col = y + dy[i];

                if(row < 0 || col < 0 || row >= N || col >= N){
                    continue;
                }

                if(visited[row][col] || houses[row][col] == 0){
                    continue;
                }

                que.offer(new int[]{row, col});
                visited[row][col] = true;
                group++;
            }
        }
        groups.add(group);
    }
}
