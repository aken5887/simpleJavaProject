package org.practice.algorithm._06_dynamic;

public class _02_fibonacci {

  private static long[] table = new long[100];

  static long fiboTopDown(int x){
    System.out.print("f("+x+") ");
    // 종료조건 명시
    if(x==2 || x==1){
      return 1;
    }
    // 계산한적이 있다면 저장된 값 return
    if(table[x] != 0){
      return table[x];
    }
    table[x] = fiboTopDown(x-1) + fiboTopDown(x-2);
    return table[x];
  }

  static long fiboBottomUp(int x){
    table[1] = 1;
    table[2] = 1;
    for(int i=3; i<x+1; i++){
      table[i] = table[i-1] + table[i-2];
    }
    return table[x];
  }

  public static void main(String[] args) {
    System.out.println(fiboTopDown(6));
    System.out.println(fiboBottomUp(50));
  }

}
