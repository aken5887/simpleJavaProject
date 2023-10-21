package org.practice.algorithm._03_DFS_BFS;

import org.practice.algorithm.MyScanner;

public class _03_DFS {
  private static int n; // 세로길이
  private static int m; // 가로길이
  private static int[][] graph = new int[1000][1000];

  // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
  static boolean dfs(int x, int y){
    // 주어진 범위를 벗어나는 경우에 즉시 종료
    if(x<=-1 || x>=n || y<=-1 || y >=m){
      return false;
    }
    // 현재 노드를 아직 방문하지 않았다면
    if(graph[x][y] == 0){
      System.out.println("x:"+x+", y:"+y);
      graph[x][y]=1; // 해당 노드 방문처리
      // 상,하,좌,우의 위치들도 모두 재귀적으로 호출
      dfs(x-1, y);
      dfs(x+1, y);
      dfs(x, y-1);
      dfs(x, y+1);
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    n = 4;
    m =5;

    String[] inputs = {"00110"
        ,"00011"
        ,"11111"
        ,"00000"};
    // 2차원 리스트의 맵 정보 입력 받기
    for(int i=0; i<n; i++){
      String str = inputs[i];
      for(int j=0; j<m; j++){
        graph[i][j] = str.charAt(j)-'0';
      }
    }

    // 모든 노드에 음료수 채우기
    int result = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        // 현재 위치에서 DFS 수행
        if(dfs(i, j)){
          System.out.println("i="+i+", j="+j);
          result++;
        }
      }
    }

    System.out.println("result : "+result);
  }
}
