package org.backjun.sorting.review;

import org.backjun.MyBufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1920 수 찾기 [복습]
 * 알고리즘 : 이분 탐색, 정렬
 * author         : choi
 * date           : 2024-02-04
 */
public class Boj_1920_FindNumber_Review1 {
    private static int N; // N개의 정수
    private static int[] arr; // N개의 정수 배열

    private static int[] nums; // 찾고자 하는 수 배열

    public static void main(String[] args) throws IOException {
        BufferedReader bf = MyBufferedReader.getInstance();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        st = MyBufferedReader.getTokenizer(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(bf.readLine());
        st = MyBufferedReader.getTokenizer(" ");
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(num)).append("\n");
        }
        System.out.println(sb);
    }

    /**
     * 이분탐색 메소드
     * @param num
     * @return
     */
    private static int binarySearch(int num){
        int start = 0;          // 시작 index
        int end = arr.length-1; // 종료 index
        int mid = 0;            // 중간 값
        while(start <= end){
            mid = (start + end) / 2; // 중간 값
            if(num < arr[mid]){
                // 중간 값 보다 앞에 있는 경우
                end = mid - 1;
            }
            else if(num > arr[mid]) {
                // 중간 값 보다 뒤에 있는 경우
                start = mid + 1;
            }
            else {
                return 1;
            }
        }
        return 0;  // 찾는 값이 없는 경우
    }
}
