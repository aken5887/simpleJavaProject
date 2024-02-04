package org.backjun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 14889 스타트 링크
 * 백준에서 제공하는 삼성 SW 역량 테스트 기출문제
 * author         : choi
 * date           : 2024-02-03
 */
public class Boj_14889_StartLink {
    private static int N;
    private static int[][] arr; // 조합점수 표
    private static boolean[] visited; // 방문 여부
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(MIN);
    }

    private static void combination(int index, int count){
        if(count == N/2){
            // 방문한 팀과 방문하지 않은 팀을 각각 나누어 각 팀의 점수를 구한다.
            score();
            return;
        }
        for(int i=index; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i+1, count+1); // 재귀
                visited[i] = false; // 재귀가 끝나면 비방문으로 변경
            }
        }
    }

    public static void score(){
        int team_start = 0;
        int team_link = 0;

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                // 방문 노드 계산
                if(visited[i] && visited[j]){
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                }
                // 비방문 노드 계산
                else if(!visited[i] && !visited[j]){
                    team_link += arr[i][j];
                    team_link += arr[j][i];
                }
            }
        }
        int diff = Math.abs(team_start - team_link);
        if(diff == 0){
            // 점수가 0점이면 최소이기 때문에 종료
            System.out.println(diff);
            System.exit(0);
        }
        MIN = Math.min(diff, MIN);
    }
}
