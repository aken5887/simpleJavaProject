package org.backjun.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 4963 섬의 개수
 * author         : choi
 * date           : 2024-02-03
 *
 * DFS가 메모리를 근소하게 덜 쓴다. 15804KB vs 16136KB
 */
public class Boj_4963_NumberOfIsland {
    private static int w;   // 너비
    private static int h;   // 높이
    private static boolean[][] visited;
    private static int[][] lands;

    private static int[] dx = {0,0,-1,1,-1,-1,1,1};
    private static int[] dy = {-1,1,0,0,-1,1,-1,1}; // 상하좌우+대각선 4방향
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line = "";
        StringBuilder sb = new StringBuilder();
        while(true){
            line = bf.readLine();
            if("0 0".equals(line)){
                break;
            }
            st = new StringTokenizer(line," ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            // 방문 초기화
            visited = new boolean[h][w];
            // 배열 초기화
            lands = new int[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(bf.readLine(), " ");
                for(int j=0; j<w; j++){
                    lands[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && lands[i][j] == 1){
                        bfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

   private static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<8; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if(nowX >= 0 && nowY >= 0 && nowX < h && nowY < w){
                if(lands[nowX][nowY] == 1 && !visited[nowX][nowY]){
                    dfs(nowX, nowY);
                }
            }
        }
   }

   private static void bfs(int x, int y){
       Queue<int[]> que = new LinkedList<>();
       que.offer(new int[]{x, y});
       visited[x][y] = true;

       while(!que.isEmpty()){
           int[] current = que.poll();
           int cx = current[0];
           int cy = current[1];

           for(int i=0; i<8; i++){
               int nx = cx + dx[i];
               int ny = cy + dy[i];
               if(nx >= 0 && ny >= 0 && nx < h && ny < w){
                    if(!visited[nx][ny] && lands[nx][ny] == 1){
                        visited[nx][ny] = true;
                        que.offer(new int[]{nx, ny});
                    }
               }
           }
       }
   }
}
