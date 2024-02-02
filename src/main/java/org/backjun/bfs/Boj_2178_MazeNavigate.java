package org.backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2178 미로 탐색
 * author         : choi
 * date           : 2/2/24
 */
public class Boj_2178_MazeNavigate {
    private static int N;
    private static int M;
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
           char[] line = bf.readLine().toCharArray();
           for(int j=0; j<line.length; j++){
               arr[i][j] = line[j] - '0';
           }
        }
        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }

   public static void bfs(int row, int col){
        // 상,하,좌,우
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{row, col});

        while(!que.isEmpty()){
            int[] now = que.poll();
            int currentRow = now[0];
            int currentCol = now[1];

            for(int i=0; i<4; i++) {
                int nextRow = currentRow + dRow[i];
                int nextCol = currentCol + dCol[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) {
                    continue;
                }

                if (visited[nextRow][nextCol] || arr[nextRow][nextCol] == 0) {
                    continue;
                }

                que.add(new int[]{nextRow, nextCol});
                arr[nextRow][nextCol] = arr[currentRow][currentCol] + 1;
                visited[nextRow][nextCol] = true;
            }
        }
   }

}
