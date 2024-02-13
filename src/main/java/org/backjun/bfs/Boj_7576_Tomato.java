package org.backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 7576 토마토
 * author         : choi
 * date           : 2024-02-12
 */
public class Boj_7576_Tomato {

    private static int M;
    private static int N;
    private static int[][] arr;

    private static Queue<int[]> que;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        que = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    que.offer(new int[]{i, j, 0});
                }
            }
        }
        bfs();
    }

    private static void bfs(){
        int days = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!que.isEmpty()){
            int[] current = que.poll();
            for(int i=0; i<4; i++){
                int mx = current[0] + dx[i];
                int my = current[1] + dy[i];
                days = current[2];

                if(mx >= 0 && my >=0 && mx < N && my < M){
                    if(arr[mx][my] == 0){
                        arr[mx][my] = 1;
                        que.offer(new int[]{mx, my, days + 1});
                    }
                }
            }
        }
        if(checkUnRiped()){
            System.out.println(-1);
        } else {
            System.out.println(days);
        }
    }

    static boolean checkUnRiped() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
