package org.practice.algorithm._06_dynamic;

public class _04_bottom_up {
  // 계산된 결과를 저장하기 위한 DP 테이블 초기화
  // 1로 만드는 데 드는 최소 횟수
  static int[] d = new int[30001];

  public static void main(String[] args) {
    int x = 26;
    // 다이나믹 프로그래밍 진행 - 보톰 업
    for(int i=2; i<=x; i++){
      // 현재의 수에서 1을 빼는 경우
      d[i] = d[i-1] + 1;
      // 현재의 수가 2로 나누어 떨어지는 경우
      if(i%2 == 0){
        d[i] = Math.min(d[i], d[i/2]+1);
      }
      if(i%3 == 0){
        d[i] = Math.min(d[i], d[i/3]+1);
      }
      if(i%5 == 0){
        d[i] = Math.min(d[i], d[i/5]+1);
      }
      System.out.println("i : "+i+", d["+i+"] :"+d[i]);
    }
    System.out.println(d[x]);
  }

}
