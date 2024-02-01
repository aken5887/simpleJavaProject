package org.backjun.bruteforce;

import java.util.Scanner;

public class Hansu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int N = 1000;
        int answer = 0;
        for(int i=1; i<=N; i++){
            String numStr = String.valueOf(i);
            char[] numArr = numStr.toCharArray();
            int diff = 0;
            boolean isHansu = true;
            for(int j=0; j<numArr.length-1; j++){
                int tmp = numArr[j+1] - numArr[j];
                if(j == 0) diff = tmp;
                if(tmp != diff){
                    isHansu = false;
                    break;
                }
                diff = tmp;
            }
            if(isHansu) answer++;
        }
        System.out.println(answer);
    }
}
