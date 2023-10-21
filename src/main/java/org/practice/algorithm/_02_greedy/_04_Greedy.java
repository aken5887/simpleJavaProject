package org.practice.algorithm._02_greedy;

import java.util.Scanner;

public class _04_Greedy {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String S = scan.next();
    int result = S.charAt(0) - '0';
    for(int i=1; i<S.length(); i++){
      int number = S.charAt(i) - '0';
      if(number<2 || result==0){
        result += number;
      }else{
        result *= number;
      }
    }
    System.out.println("result = " + result);
  }
}
