package org.practice.algorithm._04_sort;

import java.util.Arrays;

public class _03_quick_sort {

  static void quickSort(int[] arr, int start, int end){
    // 원소가 1개인 경우 종료
    if(start >= end) return;
    // pivot은 첫 번쨰 원소
    int pivot = start;
    int left = start+1;
    int right = end;

    while(left<=right){
      while(left<=end && arr[left] <= arr[pivot]){
        left++; // 피벗보다 큰 데이터를 찾을 때 까지 반복
      }
      while(right>start && arr[right] >= arr[pivot]){
        right--; // 피벗보다 작은 데이터를 찾을 떄 까지 반복
      }
      // 엇갈렸다면 작은 데이터와 피벗을 교체
      if(left > right){
        int tmp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = tmp;
      }
      // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
      else{
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
      }
    }
    // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
    quickSort(arr, start, right -1);
    quickSort(arr, right+1, end);
  }
  public static void main(String[] args) {
    int n = 10;
    int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
    quickSort(arr, 0, n-1);
    Arrays.stream(arr).forEach(i-> System.out.print(i+" "));
  }
}
