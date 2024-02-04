package org.backjun.backtracking.review;

import java.util.Scanner;

/**
 * N-Queen 문제
 * 알고리즘 : 백 트래킹
 * author         : choi
 * date           : 2024-02-04
 */
public class Boj_9663_NQueen_Review1 {
    /**
     * 퀸은 직선, 대각선 공격이 모두 가능하다.
     * 직선, 대각선 상 겹치지 않게 퀸을 배치 해야 한다.
     */
    // 각 배열의 index = 열
    // 각 배열의 index 의 값 = 행
    private static int[] arr;
    private static int N;
    private static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
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
            arr[depth] = i; // 해당 열에 놓일 수 있는 행
            if(isPlaceQueen(depth)){
                nQueen(depth + 1);
            }
        }
    }
    // 해당 열에 해당 행이 놓일 수 있는가
    private static boolean isPlaceQueen(int depth){
        for(int i=0; i<depth; i++){
            // 이전 열 중에 같은 행이 존재하는지 확크
            if(arr[i] == arr[depth]) {
                return false;
            }
            // 대각선인지 체크
            else if(Math.abs(arr[i] - arr[depth]) == Math.abs(i - depth)){
                return false;
            }
        }
        return true;
    }
}
