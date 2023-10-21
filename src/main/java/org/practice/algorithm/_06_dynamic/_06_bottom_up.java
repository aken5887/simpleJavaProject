package org.practice.algorithm._06_dynamic;

public class _06_bottom_up {

  public static void main(String[] args) {
    int row = 3;
    int column = 4;
    int[] input = {1,3,3,2,2,1,4,1,0,6,4,7};
    // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
    int[][] dp = new int[row][column];
    int k = 0;
    for(int i=0; i<row; i++){
      for(int j=0; j<column; j++){
        dp[i][j] = input[k];
        k++;
      }
    }
    // 다이나믹 프로그래밍 진행
    for(int j=1; j<column; j++){ // 열
      for(int i=0; i<row; i++){  // 행
        int fromBottom = 0;
        int fromLeft = 0;
        int fromTop = 0;
        // 왼쪽 위에서 오는경우
        if(i == 0){
          fromTop = 0;
        }else{
          fromTop = dp[i-1][j-1];
        }
        // 왼쪽 아래에서 오는 경우
        if(i == row-1){
          fromBottom = 0;
        }else{
          fromBottom = dp[i+1][j-1];
        }
        // 왼쪽
        fromLeft=dp[i][j-1];
        dp[i][j] = dp[i][j]+Math.max(Math.max(fromLeft, fromTop), fromBottom);
      }
    }
    int result = 0;
    for(int i=0; i<row; i++){
      // 마지막 열 중에서 최대값(최적의 해) 출력
      result = Math.max(result, dp[i][column-1]);
    }
    System.out.println(result);
  }
}
