package org.practice.algorithm._04_sort;

import java.util.Arrays;

public class _02_insertion_sort {
  public static void main(String[] args) {
    int[] arrays = {7,3,1,5,9,8,2};
    for(int i=1; i<arrays.length; i++){
      // 인덱스 i부터 1까지 감소하며 반복하는 문법
      for(int j=i; j>0; j--){
        // 한칸씩 왼쪽으로 이동
        if(arrays[j] < arrays[j-1]){
          int tmp = arrays[j];
          arrays[j] = arrays[j-1];
          arrays[j-1] = tmp;
        }else{
          break;
        }
      }
    }
    Arrays.stream(arrays)
        .forEach(num -> System.out.print(num+" "));
  }

}
