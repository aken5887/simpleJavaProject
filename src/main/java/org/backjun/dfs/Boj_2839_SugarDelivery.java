package org.backjun.dfs;

import java.util.Scanner;

/**
 * 백준 2839 설탕 배달
 * author         : choi
 * date           : 2024-02-03
 */
public class Boj_2839_SugarDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int count = 0; // 3만큼 빼주는 횟수
        // 5로 나누고 3을 빼서 최소 값을 구한다.
        // N이 음수가 된다면 -1 리턴
        while(true){
            if(N % 5 == 0){
                System.out.println(N/5 + count);
                break;
            }
            else if( N < 0 ) {
                System.out.println(-1);
                break;
            }
            N = N - 3;
            count++;
        }
    }

}
