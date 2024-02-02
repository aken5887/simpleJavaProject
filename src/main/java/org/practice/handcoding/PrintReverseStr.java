package org.practice.handcoding;

import java.util.Scanner;

/**
 * 입력 문자열을 거꾸로 출력하는 코드를 짜주세요.
 */
public class PrintReverseStr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        printReverseStr(input);
        printSimpleReverseStr(input);
    }

    public static void printSimpleReverseStr(String input){
        System.out.println(new StringBuilder(input).reverse());
    }

    public static void printReverseStr(String input){
        char[] c = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = c.length-1; i>=0; i--){
            sb.append(c[i]);
        }
        System.out.println(sb);
    }

}
