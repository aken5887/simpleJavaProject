package org.backjun.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 10816 숫자 카드 2
 * author         : choi
 * date           : 2024-02-08
 */
public class Boj_10816_NumberCard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int K = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++){
            int k = Integer.parseInt(st.nextToken());
            sb.append(higherBound(arr, k) - lowerBound(arr, k)).append(" ");
        }
        System.out.println(sb);
    }

    // k와 같은 값이 나타나는 첫 인덱스 k <= index
    private static int lowerBound(int[] arr, int k){
        int low = 0;
        int high = arr.length;
        // low와 high가 같아질 떄까지 반복
        while(low < high){
            int mid = low + (high - low) /2;
            if(k <= arr[mid]){
                // mid 위치 값 보다 k값보다 작거나 같은 경우
                high = mid;
            } else {
                // mid 위치 값 보다 k 값이 크다면
                low = mid + 1;
            }
        }
        return low;
    }

    // k보다 큰 수의 첫 인덱스 k < index
    private static int higherBound(int[] arr, int k){
        int low = 0;
        int high = arr.length;
        // low가 high와 같아 질 떄까지 반복
        while(low < high){
            int mid = low + (high - low) / 2;

            if(k < arr[mid]){
                // key 값이 중간 위치의 값 보다 작은 경우 (초과하는 값)
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
