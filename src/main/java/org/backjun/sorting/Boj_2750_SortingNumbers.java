package org.backjun.sorting;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 2750 수 정렬하기
 * author         : choi
 * date           : 2024-02-02
 */
public class Boj_2750_SortingNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        for(int num:arr){
            System.out.println(num);
        }
    }
}
