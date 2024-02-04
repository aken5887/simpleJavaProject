package org.backjun.backtracking.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * author         : choi
 * date           : 2024-02-04
 */
public class Boj_14889_StartLink_Review1 {
    private static int N;
    private static int[][] arr;
    private static boolean[] visited;

    private static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine()," ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(MIN);
    }

    private static void dfs(int index, int count){
        if(count == N/2){
            calculateScore();
            return;
        }

        for(int i=index; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i + 1, count+1);
                visited[i] = false;
            }
        }
    }

    private static void calculateScore(){
        int score_start = 0;
        int score_link = 0;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(visited[i] && visited[j]){
                    score_start += arr[i][j];
                    score_start += arr[j][i];
                } else if(!visited[i] && !visited[j]) {
                    score_link += arr[i][j];
                    score_link += arr[j][i];
                }
            }
        }
        int diff = Math.abs(score_start-score_link);
        if(diff == 0){
            System.out.println(0);
            System.exit(0);
        }
        MIN = Math.min(diff, MIN);
    }
}
