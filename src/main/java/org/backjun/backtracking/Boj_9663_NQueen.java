package org.backjun.backtracking;

import java.util.Scanner;

/**
 * 백준 9663 N-Queen
 * author         : choi
 * date           : 2024-02-03
 */
public class Boj_9663_NQueen {
    // arr의 index = 열의 위치
    // arr의 값 = 행의 위치
    private static int[] arr; // 체스판
    private static int N; // 체스판의 크기
    private static int count = 0;   // 경우의 수
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        arr = new int[N];
        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i;
            // 해당 열에서 i 번째 행에 놓을 수 있는지 검사하는 함수
            if(isCheckMate(depth)){
                nQueen(depth + 1);
            }
        }
    }

    /**
     * 놓인 위치가 다른 퀸의 위협을 받는지 판별하는 함수
     * @param  depth
     * @return
     */
    private static boolean isCheckMate(int depth){
        for(int i=0; i < depth; i++){
            // 이전 배열 요소 중에 같은 행에 존재하는 퀸이 있는지 확인
            if(arr[depth] == arr[i]){
                return false;
            }

            // 대각선 상에 놓여있는 케이스 확인
            // 열의 차와 행의 차와 같을 경우에 대각선에 놓여있다는 뜻
            else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
