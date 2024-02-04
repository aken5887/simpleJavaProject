package org.backjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 14501 퇴사
 * author         : choi
 * date           : 2024-02-03
 */
public class Boj_14501_Resign {
    private static int N; // 상담 일수
    private static int[] prices;
    private static int[] days;

    private static int[] dp; /// N일에 얻을 수 있는 최대 수익

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        prices = new int[N];
        days = new int[N];
        dp = new int[N+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            days[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            if(i+days[i] <= N){
                // 날짜가 범위를 넘어가지 않는 경우
                dp[i+days[i]] = Math.max(dp[i+days[i]], dp[i] + prices[i]);
            }
            // 현재 날짜의 경우의 수가 0일인 경우를 고려해서 이전까지 일한 최대수당을 넣어준다.
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }

}
