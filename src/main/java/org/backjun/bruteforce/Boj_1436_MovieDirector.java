package org.backjun.bruteforce;

import java.util.Scanner;

/**
 * 백준 1436번 영화감독 숌
 */
public class Boj_1436_MovieDirector {
    public static void main(String[] args) {
        // 666 1666 2666 3666.. 9666 106666 11666
        // N은 10,000보다 작거나 같은 자연수
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int number = 1;
        int count = 0;
        while(N > count){
            if(String.valueOf(number).contains("666")){
                count++;
            }
            number++;
        }
        System.out.println(number-1);
    }
}
