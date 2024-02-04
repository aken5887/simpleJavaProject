package org.backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2468번 안전영역
 * author         : choi
 * date           : 2024-02-02
 */
public class Boj_2468_SafeZone {
    private static int N;   // 2차원 배열의 행과 열의 개수
    private static int[][] walls; // 2차원 배열의 개수
    private static boolean[][] visited; // 방문 여부 2차원 배열
    private static int MIN = Integer.MAX_VALUE; // 최소 높이 값
    private static int MAX = Integer.MIN_VALUE; // 최대 높이 값
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        walls = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for(int j=0; j<N; j++){
                int wall = Integer.parseInt(st.nextToken());
                walls[i][j] = wall;
                MIN = Math.min(wall, MIN);
                MAX = Math.max(wall, MAX);
            }
        }
        int maxGroup = Integer.MIN_VALUE;
        for(int depth=0; depth<=MAX; depth++){
            int group = 0;
            visited = new boolean[N][N];
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(!visited[j][k] && walls[j][k] > depth){
                        bfs(depth, j, k);
                        group++;
                    }
                }
            }
            maxGroup = Math.max(group, maxGroup);
        }
        System.out.println(maxGroup);
    }

    private static void bfs(int depth, int startX, int startY){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!que.isEmpty()){
            int[] current = que.poll();
            int cx = current[0];
            int cy = current[1];
            for(int i=0; i<4; i++){
                int mx = cx + dx[i];
                int my = cy + dy[i];
                if(mx<0 || my<0 || mx>=N || my>=N) continue;
                if(visited[mx][my] || walls[mx][my] <= depth) continue;
                visited[mx][my] = true;
                que.offer(new int[]{mx, my});
            }
        }
    }
}
