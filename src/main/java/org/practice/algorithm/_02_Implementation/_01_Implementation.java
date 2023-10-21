package org.practice.algorithm._02_Implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.practice.algorithm.MyScanner;

public class _01_Implementation {

  public static void main(String[] args) {
//    Scanner scan = new Scanner(System.in);
    int N = MyScanner.scan.nextInt();
    MyScanner.scan.nextLine();
    String[] plans = MyScanner.scan.nextLine().split(" ");
    // L, R, U, D에 대한 방향
    Map<String, Integer> moveMap = new HashMap<>();
    moveMap.put("L", 0);
    moveMap.put("R", 1);
    moveMap.put("U", 2);
    moveMap.put("D", 3);
    int dx[] = {0, 0, -1, 1};
    int dy[] = {-1, 1, 0, 0};

    int x = 1;
    int y = 1;

    for(String plan:plans){
      int dir = moveMap.get(plan);
      int nx = x + dx[dir];
      int ny = y + dy[dir];

      if(nx<1 || nx>N || ny<1 || ny>N){
        continue;
      }
      x = nx;
      y = ny;
    }

    System.out.println("x:"+x+", y:"+y);
  }
}
