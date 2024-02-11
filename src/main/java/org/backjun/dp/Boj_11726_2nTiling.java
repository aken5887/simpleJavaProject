package org.backjun.dp;

import java.util.Scanner;

/**
 * 백준 11726 2xn 타일링
 * author         : choi
 * date           : 2024-02-11
 */
public class Boj_11726_2nTiling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 1 ~ 1,000
        int[] arr = new int[N];
        arr[0] = 1;
        if(N > 1) arr[1] = 2;
        for(int i=2; i<N; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 10_007;
        }
        System.out.println(arr[N-1]);
    }
}
