package org.backjun.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 9012 괄호
 * author         : choi
 * date           : 2024-02-10
 */
public class Boj_9012_Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            String lineInput = bf.readLine();
            sb.append(isVPS(lineInput)).append("\n");
        }
        System.out.println(sb);
    }

    private static String isVPS(String lineInput) {
        Stack<Character> stack = new Stack<>();
        char[] chars = lineInput.toCharArray();
        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            if(!stack.isEmpty() && c == ')' && stack.peek() == '('){
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty()?"YES":"NO";
    }
}
