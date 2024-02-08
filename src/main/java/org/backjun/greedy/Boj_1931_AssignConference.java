package org.backjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 1931 회의실 배정
 * author         : choi
 * date           : 2024-02-08
 */
public class Boj_1931_AssignConference {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] times = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });

        int count = 0;
        int prevEnd = 0;
        for(int[] time:times){
            if(prevEnd <= time[0]){
                count++;
                prevEnd = time[1];
            }
        }
        System.out.println(count);
    }
}
