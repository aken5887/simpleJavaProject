package org.practice.algorithm._02_greedy;

public class _01_Greedy {
  public static void main(String[] args) {
    int n = 1280;
    int count = 0;
    int[] coins = {500, 100, 50, 10};
    // 2, 2, 1, 3 = 8
    for(int coin:coins){
      count += n/coin;
      n%=coin;
    }
    System.out.println(count);
  }
}
