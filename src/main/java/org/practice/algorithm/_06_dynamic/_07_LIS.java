package org.practice.algorithm._06_dynamic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class _07_LIS {
  public static void main(String[] args) {
    int n = 7;
    List<Integer> list = Arrays.asList(15, 11, 4, 8, 5, 2, 4);
    int[] dp = new int[2000];
    // 순서 뒤집기
    Collections.reverse(list);
    // 다이내믹 프로그래밍을 위한 1차원 DP 테이블 초기화
    for(int i=0; i<dp.length;i++){
      dp[i] = 1; // 초기화
    }
    // 가장 긴 증가하는 부분 수열 (LIS) 알고리즘 수행
    for(int i=1; i<n; i++){
      for(int j=0; j<i; j++){
        if(list.get(j) < list.get(i)){
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
    }
    // 열외해야 하는 병사의 최소 수를 출력
    int maxValue = 0;
    for(int i=0; i<n; i++){
      maxValue = Math.max(maxValue, dp[i]);
    }
    IntStream.range(0, n)
            .forEach(i-> System.out.print("("+list.get(i)+","+dp[i]+"),"));
    System.out.println();
    System.out.println(n-maxValue);
  }
}
