package org.practice.algorithm._03_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

class Node{
  private int x;
  private int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}

public class _04_BFS {
  private static int row = 5;
  private static int column = 6;
  private static int[][] graph = new int[201][201];
  // 이동할 4가지 방향 (상, 하, 좌, 우)
  private static int dx[] = {-1, 1, 0, 0};
  private static int dy[] = {0, 0, -1, 1};

  public static int bfs(int x, int y){
    Queue<Node> q= new LinkedList<>();
    q.offer(new Node(x, y));
    // 큐가 빌 때까지
    while(!q.isEmpty()){
      Node node = q.poll();
      x = node.getX();
      y = node.getY();
      // 현재 위치에서 4가지 방향으로 위치 확인
      for(int i=0; i<4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        // 공간을 벗어난 경우 무시
        if(nx<0 || nx>=row || ny<0 || ny>=column){
          continue;
        }
        // 벽인 경우 무시
        if(graph[nx][ny] == 0){
          continue;
        }
        // 해당 노드를 처음 방문하는 경우에만 최단거리 기록
        if(graph[nx][ny] ==1){
          System.out.println("현재위치 : x="+nx+",y="+ny+",graph="+graph[x][y]);
          graph[nx][ny] = graph[x][y] +1; // 1씩 더함
          System.out.println("다음위치 : nx="+nx+",ny="+ny+",graph="+graph[nx][ny]);
          q.offer(new Node(nx, ny));
        }
      }
    }
    // 가장 오른쪽 아래까지의 최단거리 반환
    return graph[row-1][column-1];
  }

  public static void main(String[] args) {
    String[] inputs = {"101010","111111","000001","111111","111111"};
    for(int i=0; i<inputs.length; i++){
      String input = inputs[i];
      for(int j=0; j<input.length(); j++){
        graph[i][j] = input.charAt(j) - '0';
      }
    }

    System.out.println(bfs(0,0));
  }

}
