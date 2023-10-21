package org.practice.algorithm._03_DFS_BFS;

public class Factorial {

  static long factorial_recursive(int n){
    if(n<=1) return 1;
    return n*factorial_recursive(n-1);
  }

  public static void main(String[] args) {
    System.out.println(factorial_recursive(50));
  }
}
