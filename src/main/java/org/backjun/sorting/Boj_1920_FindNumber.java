package org.backjun.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1920 수 찾기 - 이분 탐색을 활용해야 한다.
 * author         : choi
 * date           : 2024-02-02
 */
public class Boj_1920_FindNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(bf.readLine());
        int[] arr2 = new int[N];
        st = new StringTokenizer(bf.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            // 찾고자 하는 값이 있는 경우
            if(binarySearch(arr, Integer.parseInt(st.nextToken())) > -1){
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int binarySearch(int[] arr, int key){
      int low = 0;
      int high = arr.length-1;

      // 시작점이 끝 점보다 작은 경우
      while(low <= high){
          int mid = (low + high) / 2;

          if(key < arr[mid]) {
              high = mid - 1; // 값이 앞에 있기 때문에 끝점을 줄여준다.
          }
          else if(key > arr[mid]){
              low = mid + 1; // 값이 뒤에 있기 떄문에 시작점을 높여준다.
          }
          else {
              return mid;
          }
      }

      return -1; // 찾고자하는 값이 없는 경우
    }
}
