package org.backjun.implmentation;

import java.util.Scanner;
import java.util.Stack;

/**
 * 백준 10773 구현
 * author         : choi
 * date           : 2024-02-11
 */
public class Boj_10773_Zero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            int number = scan.nextInt();
            if(0 == number){
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
