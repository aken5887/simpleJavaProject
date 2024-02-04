package org.backjun.bfs.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * author         : choi
 * date           : 2024-02-04
 */
public class Boj_2178_MazeNavigate_Review1 {
    private static int N;
    private static int M;
    private static int[][] map;

    private static int[][] map2;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1,1,0,0};
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        map2 = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i< N; i++){
            char[] lines = bf.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = lines[j] - '0';
                map2[i][j] = map[i][j];
            }
        }
        System.out.println(bfs(0, 0));
        // DFS로는 가장 빠른 길을 찾을 수 가 없다...
        visited = new boolean[N][M];
        dfs(0, 0);
        System.out.println(map2[N-1][M-1]);
    }

    private static int bfs(int startX, int startY){
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

                if(mx >= 0 && my >=0 && mx < N && my < M) {
                    if(!visited[mx][my] && map[mx][my] == 1){
                        visited[mx][my] = true;
                        map[mx][my] = map[cx][cy] + 1;
                        que.offer(new int[]{mx, my});
                    }
                }
            }
        }
        return map[N-1][M-1];
    }

    private static void dfs(int startX, int startY){
        visited[startX][startY] = true;
        for(int i=0; i<4; i++){
            int mx = startX + dx[i];
            int my = startY + dy[i];
            if(mx >= 0 && my >= 0 && mx < N && my < M){
                if(!visited[mx][my] && map2[mx][my] == 1){
                    map2[mx][my] = map2[startX][startY] + 1;
                    dfs(mx, my);
                }
            }
        }
    }
}
