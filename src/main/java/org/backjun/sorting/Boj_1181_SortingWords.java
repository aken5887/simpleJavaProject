package org.backjun.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1181번 단어 정렬
 * author         : choi
 * date           : 2024-02-02
 */
public class Boj_1181_SortingWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<String> str = new ArrayList<>();
        for(int i=0; i<N; i++){
            String newStr = bf.readLine();
            if(!str.contains(newStr)) str.add(newStr);
        }
        Collections.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    for(int i=0; i<o1.length(); i++){
                        if(o1.charAt(i) != o2.charAt(i)){
                            return Integer.compare(o1.charAt(i), o2.charAt(i));
                        }
                    }
                    return 0;
                } else {
                    return Integer.compare(o1.length(), o2.length());
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s:str){
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }
}
