package org.practice.algorithm._02_greedy;

import java.util.Scanner;

public class _03_Greedy {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int K = scanner.nextInt();
    int count = 0;

    while(N>1){
      int target = (N/K)*K;
      count += (N - target);
      N = target;
      if(N<K) break;
      // K로 나누기
      count++;
      N /= K;
    }
    System.out.println("카운트 : " + count);
  }
}
