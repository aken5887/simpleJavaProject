package org.practice.algorithm._02_Implementation;

import org.practice.algorithm.MyScanner;

public class _03_Implementation {
  public static void main(String[] args) {
    String input = MyScanner.scan.next();
    int row = input.charAt(1)-'0';
    int column = input.charAt(0)-'a'+1;
    int[] dx = {2,-2,2,-2,1,1,-1,-1};
    int[] dy = {1,1,-1,-1,2,-2,2,-2};
    int count = 0;
    for(int i=0; i<dx.length; i++){
      int nextRow = row + dy[i];
      int nextColumn = column + dx[i];
      //이동이 가능하다면 count값 증가
      if(nextRow >=1 && nextRow <=8 && nextColumn >=1 && nextColumn <=8){
        count++;
      }
    }
    System.out.println("count : "+count);
  }
}
