package org.backjun.dp;

import java.util.Scanner;

/**
 * 백준 2579번 계단 오르기
 * author         : choi
 * date           : 2024-02-11
 */
public class Boj_2579_ClimbStairs_TopDown {
    private static Integer dp[];
    private static int arr[];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 계단의 갯수
        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = scan.nextInt();
        }
        dp = new Integer[N+1];
        dp[0] = arr[0];
        dp[1] = arr[1];
        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        // 계단은 한번에 하나 or 두개씩 오를 수 있다. (o)
        // 계단을 연속 3번 밟으면 안된다.
        // 마지막 계단은 반드시 밟아야 함 (o)
        // TODO Top-Down 방식으로 풀어보기 (탑 다운 방식은 재귀로 풀어야 함)
        // 로직
        // dp[i] = Math,max(dp[i-2] , dp[i-3] + arr[i-1) + arr[i]
        System.out.println(topDown(N));
    }

    private static int topDown(int N) {
        if(dp[N] == null) // 아직 탐색하지 않은 N번째 계단이라면
        {
            dp[N] = Math.max(topDown(N-2), topDown(N-3) + arr[N-1]) + arr[N];
        }
        return dp[N];
    }

}
