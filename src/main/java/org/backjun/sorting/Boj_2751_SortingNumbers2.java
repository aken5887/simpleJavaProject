package org.backjun.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 2751 수 정렬하기 2
 * author         : choi
 * date           : 2024-02-02
 */
public class Boj_2751_SortingNumbers2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int num:arr){
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());
    }
}
