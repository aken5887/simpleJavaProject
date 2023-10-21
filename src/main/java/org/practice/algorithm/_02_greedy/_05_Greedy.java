package org.practice.algorithm._02_greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.w3c.dom.ls.LSOutput;

public class _05_Greedy {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    scan.nextLine();
    String[] scaryInput = scan.nextLine().split(" ");
    System.out.println(scaryInput.length);
    int[] scaryList =Arrays.stream(scaryInput)
            .mapToInt(scary -> Integer.parseInt(scary)).toArray();
    Arrays.sort(scaryList);

    int result = 0; // 총 그룹수
    int count = 0; // 현재 그룹에 포험된 모험가 수

    for(int scary:scaryList){
      // 현재 그룹에서 해당 모험가 포함
      count++;
      // 현재 모험가의 공포도보다 그룹수가 많다면
      if(count >= scary) {
        result++; // 그룹수 증가
        count=0; // 그룹 내 인원 추기화
      }
    }
    System.out.println("result : "+result);
  }
}
