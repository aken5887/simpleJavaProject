package org.backjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1929번 소수 구하기
 * author         : choi
 * date           : 2024-02-10
 */
public class Boj_1929_PrimeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        // 1 <= M <= N <= 1_000_000
        for(int i=M; i<=N; i++){
            if(isPrimeNumber(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean isPrimeNumber(int number){
        if(number < 2) return false;
        for(int i=2; i <= Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}
