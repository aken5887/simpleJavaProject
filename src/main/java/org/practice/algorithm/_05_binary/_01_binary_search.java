package org.practice.algorithm._05_binary;

public class _01_binary_search {
  static Integer binarySearch(int[] array, int target, int start, int end){
    if(start > end){
      return null;
    }
    int mid = (start+end)/2;
    // 찾은 경우 중간 점 인덱스 반환
    if(array[mid] == target){
      return mid;
    }
    // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
    else if(array[mid] > target){
      return binarySearch(array, target, start, mid-1);
    }
    // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른 쪽 확인
    else {
      return binarySearch(array, target, mid+1, end);
    }
  }

  static Integer binarySearchLoop(int[] array, int target, int start, int end){
    while(start<=end){
      int mid = (start+end)/2;
      if(array[mid] == target){
        return mid;
      }else if(array[mid] > target){ // target이 중간점의 값보다 작은경우
        end = mid-1;
      }else { // target이 중간점의 값보다 큰 경우
        start = mid+1;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] array = {1,2,4,5,7,10,12,13,15,17};
    Integer result = binarySearch(array, 22, 0, array.length-1);
    if(result == null){
      System.out.println("원소가 존재하지 않습니다.");
    }else{
      System.out.println("해당 원소의 위치 = "+(result+1));
    }

    Integer result2 = binarySearchLoop(array, 17, 0, array.length-1);
    if(result2 == null){
      System.out.println("원소가 존재하지 않습니다.");
    }else{
      System.out.println("해당 원소의 위치 = "+(result2+1));
    }
  }
}
