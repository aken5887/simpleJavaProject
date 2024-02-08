package org.backjun.implmentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1316 그룹 단어 체커
 * author         : choi
 * date           : 2024-02-08
 */
public class Boj_1316_GroupWordChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] arr = new String[N];
        int count = 0;

        for(int i=0; i<N; i++){
            arr[i] = bf.readLine();
            boolean isGroup = groupWordCheck(arr[i]);
            if(isGroup) count++;
        }
        System.out.println(count);
    }

    private static boolean groupWordCheck(String s){
        for(int i=0; i<s.length(); i++){
            int next = s.indexOf(s.charAt(i), i+1);
            if(next-i > 1 && next != -1){
                return false;
            }
        }
        return true;
    }
}
