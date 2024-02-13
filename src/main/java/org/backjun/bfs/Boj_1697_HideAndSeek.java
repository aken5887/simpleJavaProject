package org.backjun.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 1697 숨바꼭질
 * author         : choi
 * date           : 2024-02-13
 */
public class Boj_1697_HideAndSeek {

    private static int N;
    private static int K;
    private static Integer[] arr = new Integer[100_001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 0 ~ 100_000
        K = scanner.nextInt(); // 0 ~ 100_000
        System.out.println(find(N));
    }

    private static int find(int start){
        Queue<Integer> que = new LinkedList<>();
        arr[start] = 0;
        que.offer(start);

        while(!que.isEmpty()){
            int current = que.poll();
            if(current == K){
                return arr[current];
            }

            if(current-1 >= 0 && arr[current-1] == null){
                que.offer(current-1); // 방문
                arr[current-1] = arr[current] + 1;
            }

            if(current+1 <= 100_000 && arr[current+1] == null){
                que.offer(current+1);
                arr[current+1] = arr[current] + 1;
            }

            if(2*current <= 100_000 && arr[2*current] == null){
                que.offer(2 * current);
                arr[2*current] = arr[current] + 1;
            }
        }

        return -1;
    }
}
