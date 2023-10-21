package org.practice.algorithm._06_dynamic;

public class _03_bottom_up {
  // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
  private static int[] d = new int[100];
  static int antWarrior(int[] array, int n){
    d[0] = array[0];
    d[1] = Math.max(array[0], array[1]);
    for(int i=2; i<array.length; i++){
      d[i] = Math.max(array[i]+array[i-2], array[i-1]);
    }
    return d[n-1];
  }

  public static void main(String[] args) {
    int N = 4;
    int[] array = {1,3,1,5};
    System.out.println(antWarrior(array, N));
  }
}
