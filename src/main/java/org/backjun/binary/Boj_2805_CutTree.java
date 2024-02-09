package org.backjun.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2805번 나무 자르기
 * author         : choi
 * date           : 2024-02-09
 */
public class Boj_2805_CutTree {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        // 1 <= N <+ 1_000_000
        int N = Integer.parseInt(st.nextToken());
        // 1 <= M <= 2_000_000_000
        int M = Integer.parseInt(st.nextToken());
        // 나무의 높이 1_000_000_000 보다 작거나 같다 - long 타입을 쓰자
        int[] trees = new int[N];
        int max = 0;
        st = new StringTokenizer(bf.readLine()," ");
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }
        Arrays.sort(trees);
        System.out.println(binarySearch(trees, M, max));
    }

    private static int binarySearch(int[] trees, int M, int max) {
        // 하한선
        int min  = 0;
        // tree 값 중 가장 큰 값
        while(min < max){
            int mid = (min + max) / 2;
            long sum = 0;
            for(int tree:trees){
                sum += Math.max(0, tree - mid);
            }
            if(sum < M){
                // 자른 나무의 길이의 합이 M 보다 작다 = 높이를 낮춰야 한다. (상한을 줄여야 한다.)
                max = mid;
            } else {
                // 자른 나무의 길이가 M보다 크다 = 높이를 높여야 한다. (하한을 올려야 한다.)
                min = mid + 1;
            }
        }
        return min - 1;
    }
}
