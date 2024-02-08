package org.backjun.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 10816 숫자 카드 2
 * author         : choi
 * date           : 2024-02-08
 */
public class Boj_10816_NumberCard2_Map {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
           map.put(number, map.getOrDefault(number, 0)+1);
        }
        int K = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++){
            int k = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(k, 0)).append(" ");
        }
        System.out.println(sb);
    }

}
