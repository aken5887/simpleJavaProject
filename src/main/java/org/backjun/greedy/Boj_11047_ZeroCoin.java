package org.backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 11047번 동전 0
 * author         : choi
 * date           : 2024-02-08
 */
public class Boj_11047_ZeroCoin {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] coins = new Integer[N];
        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(coins, Collections.reverseOrder());
        int amount = 0;
        for(int coin:coins){
            amount += K / coin;
            K = K % coin;
            if(K == 0) break;
        }
        System.out.println(amount);
    }
}
