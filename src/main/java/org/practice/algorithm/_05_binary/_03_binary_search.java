package org.practice.algorithm._05_binary;

public class _03_binary_search {

  static int binarySearch(int[] arr, int target){
    int start = -1;
    int end = -1;
    int result = 0;

    for(int i=0; i<arr.length; i++){
      if(arr[i] == target){
        start = i;
        break;
      }
    }
    for(int i=(arr.length-1); i>0; i--) {
      if (arr[i] == target) {
        end = i;
        break;
      }
    }
    if(start < 0 || end < 0){
      return 0;
    }
    result = (end-start+1);
    return result;
  }

  public static void main(String[] args) {
    int[] array = {1,1,2,2,2,2,3};
    int result = binarySearch(array, 2);
    System.out.println("갯수 : "+result);
  }
}
