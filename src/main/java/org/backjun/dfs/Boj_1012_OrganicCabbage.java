package org.backjun.dfs;

import org.checkerframework.checker.units.qual.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1012번
 * author         : choi
 * date           : 2024-02-02
 */
public class Boj_1012_OrganicCabbage {

    private static int T;   // 테스트 케이스의 개수
    private static int M;   // 배추 밭의 가로 길이
    private static int N;   // 배추 밭의 세로 길이
    private static int K;   // 배추가 심어져 있는 위치의 개수
    private static int[][] arr; // 배추 밭
    private static boolean[][] visited; // 방문여부
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[M][N];
            visited = new boolean[M][N];
            int result = 0;
            for(int j=0; j<K; j++){
                st = new StringTokenizer(bf.readLine(), " ");
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                arr[row][col] = 1;
            }
            for(int k=0; k<M; k++){
                for(int m=0; m<N; m++){
                    if(!visited[k][m] && arr[k][m] == 1){
                        bfs(k, m);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void bfs(int row, int col){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{row, col});
        visited[row][col] = true;

        while(!que.isEmpty()) {
            int[] node = que.poll();
            int cx = node[0];
            int cy = node[1];
            for (int i = 0; i < 4; i++) {
                int mx = cx + dx[i];
                int my = cy + dy[i];
                if (mx < 0 || my < 0 || mx >= M || my >= N) {
                    continue;
                }
                if (visited[mx][my] || arr[mx][my] == 0) {
                    continue;
                }
                visited[mx][my] = true;
                que.offer(new int[]{mx, my});
            }
        }
    }
}
