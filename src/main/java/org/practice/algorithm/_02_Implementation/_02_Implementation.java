package org.practice.algorithm._02_Implementation;

import java.util.Scanner;
import org.practice.algorithm.MyScanner;

public class _02_Implementation {

  public static void main(String[] args) {
    int N = MyScanner.scan.nextInt();
    int count = 0;
    for(int i=0; i<=N; i++){
      for(int j=0; j<60; j++){
        for(int k=0; k<60; k++){
          if(check(i,j,k)){
            count++;
          }
        }
      }
    }
    System.out.println("count : "+count);
  }

  // 시, 분 초에 3이 들어가는지 체크
  static boolean check(int h, int m, int s){
    if(h%10==3 || m/10==3 || m%10==3 || s/10==3 || s%10==3){
      return true;
    }
    return false;
  }
}
