package org.backjun.dp;

import java.util.Scanner;

/**
 * 백준 1463 1로 만들기
 * author         : choi
 * date           : 2024-02-03
 */
public class Boj_1463_MakeOne {
    private static int[] dp; // 메모이제이션 배열
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        dp = new int[N+1];
        // 각 부분에 재취호출을 하면서 DP를 최소값을 갱신시켜줘야 한다.
        // 각 부분에 이전 재귀호출 중 최소 값에 1을 더한 것이 현재 N에 대한 최소 연산횟수가 된다.
        System.out.println(recur(N));
    }


    private static int recur(int N){
        if(dp[N] == 0 & N > 1){
            if(N % 6 == 0){
                dp[N] = Math.min(recur(N-1), Math.min(recur(N/3), recur(N/2)))+1;
            }
            // 3으로 나눠 떨어지는 경우
            // 3이 곱해서 N이 되거나, 1이 더해져서 N이 되는 경우의 수 중에 작은 것에 1을 더함
            else if(N % 3 == 0){
                dp[N] = Math.min(recur(N/3), recur(N-1)) + 1;
            }
            else if(N % 2 == 0){    // 2로만 나눠지는 경우
                dp[N] = Math.min(recur(N/2), recur(N-1)) + 1;
            }
            else { // 2와 3으로 나눠지지 않는 경우
                dp[N] = recur(N-1) + 1;
            }
        }
        return dp[N];
    }
}
