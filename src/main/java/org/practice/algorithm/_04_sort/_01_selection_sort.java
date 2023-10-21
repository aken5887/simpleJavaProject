package org.practice.algorithm._04_sort;

import java.util.Arrays;

public class _01_selection_sort {

  public static void main(String[] args) {
    int[] array = {7,5,1,2,4,6,0};
    Arrays.stream(selectionSort(array))
        .forEach(i -> System.out.print(i+" "));
  }

  static int[] selectionSort(int[] array){
    for(int i=0; i<array.length-1; i++){
      for(int j=i+1; j<array.length; j++){
        System.out.println(array[i]+"VS"+array[j]);
        if(array[i]>array[j]){
          int tmp = array[i];
          array[i] = array[j];
          array[j] = tmp;
        }
      }
    }
    return array;
  }
}
