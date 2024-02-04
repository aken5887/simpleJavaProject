package org.backjun.dp;

import java.util.Scanner;

/**
 * 백준 1003 피보나치 함수
 * author         : choi
 * date           : 2024-02-03
 */
public class Boj_1003_Fibonacci {

    // N은 40보다 작거나 같은 자연수 또는 0
    private static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        dp[0][0] = 1; // N=0 일 때 0의 호출수
        dp[0][1] = 0; // N=0 일 때 1의 호출 수
        dp[1][0] = 0; // N=1 일 때 0의 호출수
        dp[1][1] = 1; // N=1 일 때 1의 호출수

        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        for(int i=0; i<M; i++){
            int N = scan.nextInt();
            finbonacci(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        System.out.println(sb);
    }

    private static Integer[] finbonacci(int N){
        // 탐색하지 않은 값 일 때
        if(dp[N][0] == null || dp[N][1] == null){
            dp[N][0] = finbonacci(N-1)[0] + finbonacci(N-2)[0];
            dp[N][1] = finbonacci(N-1)[1] + finbonacci(N-2)[1];
        }
        return dp[N];
    }
}
