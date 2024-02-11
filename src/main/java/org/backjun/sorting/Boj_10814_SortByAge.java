package org.backjun.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 10814 나이순 정렬
 * author         : choi
 * date           : 2024-02-11
 */
public class Boj_10814_SortByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[][] members = new String[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            members[i][0] = st.nextToken();
            members[i][1] = st.nextToken();
        }

        Arrays.sort(members, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])){
                    return 0;
                } else {
                    return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String[] member:members){
            sb.append(member[0]).append(" ").append(member[1]).append("\n");
        }
        System.out.println(sb);
    }
}
