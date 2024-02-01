package org.prepare._07_findLongestPart;

import java.util.Stack;

public class FindLongestPart {
    public static void main(String[] args) {
        FindLongestPart findLongestPart = new FindLongestPart();
        System.out.println(findLongestPart.solution(")()()("));
        System.out.println(findLongestPart.solution("(()())"));
        System.out.println(findLongestPart.solution("(()())())((()()()()))))(((())()())())()()"));
        System.out.println(findLongestPart.solution(")))(((("));
    }

    private int solution(String input){
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int maxLength = 0;
        boolean isContinuos = false;

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if(c == '('){
                stack.push(c);
            } else if(!stack.isEmpty() && c == ')' && stack.peek() == '('){
                if(isContinuos){
                    maxLength += 2;
                    answer = Math.max(answer, maxLength);
                } else {
                    maxLength = 2;
                    isContinuos = true;
                }
                stack.clear();
            } else{
                // 올바른 괄호가 아님
                stack.clear();
                maxLength = 0;
                isContinuos = false;
            }
        }

        return answer;
    }

}
