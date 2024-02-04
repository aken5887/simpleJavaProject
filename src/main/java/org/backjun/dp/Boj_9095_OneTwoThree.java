package org.backjun.dp;

import java.util.Scanner;

/**
 * 백준 9095 1,2,3 더하기
 * author         : choi
 * date           : 2024-02-03
 */
public class Boj_9095_OneTwoThree {
    private static int[] dp;
    public static void main(String[] args) {
        // 정수 N이 주어졌을 때, 1,2,3의 합으로 나타 낼 수 있는 방법의 수
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int M = scan.nextInt();
        for(int i=0; i<M; i++){
            int N = scan.nextInt();
            dp = new int[N+1];
            if(N == 1) sb.append(1);
            else if(N == 2) sb.append(2);
            else if(N == 3) sb.append(4);
            else sb.append(recur(N));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int recur(int N){
        dp[1] = 1; // (1)
        dp[2] = 2; // (2) (1,1)
        dp[3] = 4; // (1,1,1) (1,2) (2,1) (3)
        // 1부터 시작
        for(int i=4; i<=N; i++){
           dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[N];
    }
}
