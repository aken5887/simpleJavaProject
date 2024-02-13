package org.backjun.dp;

import java.util.Scanner;

/**
 * 백준 9461 파도반수열
 * author         : choi
 * date           : 2024-02-13
 */
public class Boj_9461_HalfWaveSequence {

    private static Long[] arr = new Long[101];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = scan.nextInt();
        for(int i=0; i<N; i++){
            int K = scan.nextInt();
            // 1,1,1,2,2,3,4,5,7,9
            // arr[N] = arr[N-2] + arr[N-3];
            find(K);
            sb.append(arr[K]).append("\n");
        }
        System.out.println(sb);
    }

    private static Long find(int K){
        arr[1] = Long.parseLong("1");
        arr[2] = Long.parseLong("1");
        arr[3] = Long.parseLong("1");

        if(arr[K] == null){
            for(int i=4; i<=K; i++){
                arr[i] = arr[i-2] + arr[i-3];
            }
        }
        return arr[K];
    }

}
