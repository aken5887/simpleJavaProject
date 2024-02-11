package org.backjun.dp;

import java.util.Scanner;

/**
 * 백준 2579번 계단 오르기
 * author         : choi
 * date           : 2024-02-11
 */
public class Boj_2579_ClimbStairs_BottomUp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 계단의 갯수
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = scan.nextInt();
        }
        // 계단은 한번에 하나 or 두개씩 오를 수 있다. (o)
        // 계단을 연속 3번 밟으면 안된다.
        // 마지막 계단은 반드시 밟아야 함 (o)
        dp[1] = arr[1];
        if(N > 1) dp[2] = arr[1] + arr[2];
        for(int i=3; i<arr.length; i++){
            // 연속 3개의 계단을 밟으면 안되기 때문에
            // 두 번 오르고 한번 오른 경우를 고려한다 (연속 두번 한개씩 오른 경우 배제)
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }
        System.out.println(dp[N]);
    }
}
