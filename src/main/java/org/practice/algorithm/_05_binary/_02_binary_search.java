package org.practice.algorithm._05_binary;

import java.util.Arrays;

public class _02_binary_search {

  static Integer binarySearch(int[] array, int target){
    int start = 0;
    int end = (int) 1e9;
    int result = 0;
    // 이진 탐색 수행
    while(start <= end){
      int mid = (start + end) / 2;
      long sum = 0;

      for(int i=0; i<array.length; i++){
        if(array[i] > mid){
          sum += array[i] - mid;
        }
      }
      // 떡의 양이 부족함 (왼쪽 부분 탐색)
      if(sum < target) {
        end = mid-1;
      }
      // 떡이 양이 충분함 (오른쪽 부분 탐색)
      else {
        result = mid; // 최대한 덜 잘랐을 때가 정답, result 기록
        start = mid+1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] array = {19, 15, 10, 17};
    Arrays.sort(array);
    int height = binarySearch(array, 6);
    System.out.println("절단기 최대 높이 : "+height+"cm");
  }
}
