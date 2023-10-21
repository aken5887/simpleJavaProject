package org.practice.algorithm._09_etc;

import java.util.Arrays;
import org.practice.algorithm.MyScanner;

public class _01_primary_number {

  public static void main(String[] args) {
    int n = MyScanner.scan.nextInt();
    boolean[] array = new boolean[n+1];
    for(int i=2; i<array.length; i++){ // 0과 1인 제외함
      array[i] = true;
    }
    // 에라토스테네스의 체 알고리즘 수행
    // 2부터 n의 제곱근까지의 모든 수를 확인하며
    for(int i=2; i<=Math.sqrt(n); i++){
      if(array[i]){ // i가 소수거나 남은 수인경우
        int j = 2;
        while(i*j <= n){
          array[i*j] = false; // i를 제외한 i의 모든 배수를 제거함
          j++;
        }
      }
    }
    // 모든 소수 출력
    for(int i=2; i<=n; i++){
      if (array[i]) {
        System.out.print(i+" ");
      }
    }
  }
}
