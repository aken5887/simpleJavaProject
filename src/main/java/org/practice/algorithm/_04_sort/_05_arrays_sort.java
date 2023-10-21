package org.practice.algorithm._04_sort;

import java.util.Arrays;
import java.util.Collections;
import org.practice.algorithm.MyScanner;

public class _05_arrays_sort {

  public static void main(String[] args) {
    int n = 5;
    int k = 3;
    String arrayA = "1 2 5 4 3";
    String arrayB = "5 5 6 6 5";

    Integer[] a = new Integer[n];
    Integer[] b = new Integer[n];

    for(int i=0; i<n; i++){
      a[i] = Integer.parseInt(arrayA.split(" ")[i]);
      b[i] = Integer.parseInt(arrayB.split(" ")[i]);
    }

    // 정렬
    Arrays.sort(a); // 오름차순
    Arrays.sort(b, Collections.reverseOrder()); // 내림차순

    long result = 0;

    for(int i=0; i<k; i++){
      if(a[i] < b[i]) {
        int tmp = a[i];
        a[i] = b[i];
        b[i] = tmp;
      }else{
        break;
      }
    }

    for(int i=0; i<n; i++){
      result += a[i];
    }

    System.out.println("result : "+result);
  }
}
