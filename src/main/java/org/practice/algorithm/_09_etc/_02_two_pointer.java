package org.practice.algorithm._09_etc;

public class _02_two_pointer {

  public static void main(String[] args) {
    int n = 5; // 데이터의 갯수
    int m = 5; // 찾고자 하는 부분합 M
    int[] data = {1,2,3,2,5};

    int count =0, sum = 0, end = 0;
    // start를 증가시키며 반복
    for(int start=0; start<n; start++){
      // end를 가능한 만큼 이동시키기
      while(sum < m && end < n){
        sum += data[end];
        end++;
      }
      // 부분합이 M일 때 count 증가
      if(sum == m){
        System.out.println("start : "+start+", end : "+(end-1));
        count++;
      }
      sum -= data[start]; // 한칸 뒤로 이동할 때 값을 빼줌
    }
    System.out.println("count : "+count);
  }
}
