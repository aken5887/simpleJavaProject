package org.practice.algorithm._06_dynamic;

import java.util.Arrays;

public class _05_bottom_up {

  public static void main(String[] args) {
    int N = 3; // 화폐의 종류
    int M = 7; // 목표 금액
    int[] array = {2,3,5};
    // 화폐단위 당 최적의 결과 테이블
    int[] d = new int[M+1];
    for(int i=0; i<d.length; i++){
      d[i] = 10001; // 초기화
    }

    d[0] = 1; // 어떠한 지폐도 사용하지 않음
    for(int i=0; i<N; i++){ // 각 화폐단위 loop
      for(int j=array[i]; j<M+1; j++){  // 금액
        if(d[j-array[i]] != 10001) { // (i-k원을 만드는 방법이 존재하는 경우
          d[j] = Math.min(d[j], d[j-array[i]]+1);
        }
      }
    }
    Arrays.stream(d)
        .forEach(e -> System.out.print(e+" "));
    System.out.println();
    if(d[M] == 10001){
      System.out.println(-1);
    }else {
      System.out.println(d[M]);
    }
  }
}
