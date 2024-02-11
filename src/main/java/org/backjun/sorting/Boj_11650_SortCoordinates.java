package org.backjun.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 11650_ 좌표정렬하기
 * author         : choi
 * date           : 2024-02-10
 */
public class Boj_11650_SortCoordinates {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 1 ~ 100_000
        int[][] coordinates = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            };
        });

        for(int[] coordinate:coordinates){
            System.out.println(coordinate[0]+" "+coordinate[1]);
        }
    }
}
