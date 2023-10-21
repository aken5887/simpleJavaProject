package org.practice.algorithm._04_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _04_counting_sort {
  private static final int MAX_VALUE = 9;
  public static void main(String[] args) {
    int n = 15;
    // 모든 원소의 값이 0보다 크거나 같다고 가정
    int[] array = {7,6,9,0,3,1,6,2,9,1,4,8,0,5,2};
    // 모든 범위를 포함하는 배열 선언(모든 값은 0으로 초기화)
    int[] cnt = new int[MAX_VALUE+1];

    for(int i=0; i<n; i++){
      cnt[array[i]]++; // 각 데이터에 해당하는 인덱스의 값 증가
    }

    for(int i=0; i<=MAX_VALUE; i++){
      for(int j=0; j<cnt[i]; j++){
        System.out.print(i+" "); // count 갯수만큼 출력
      }
    }
  }
}
