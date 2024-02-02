package org.practice.handcoding;

import java.util.Stack;

/**
 * Stack에서 계속해서 push/pop 되는 상황에서 O(1)로 최소값을 찾는 스택 구현
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private int MIN = Integer.MAX_VALUE;
    public MinStack() {
        for(int i=0; i<10; i++){
            int number = (int) (Math.random() * 100);
            stack.push(number);
            System.out.print(number+" ");
        }
        System.out.println();
    }

    public MinStack(int size) {
        for(int i=0; i<size; i++){
            int number = (int) (Math.random() * 100);
            stack.push(number);
            System.out.print(number+" ");
        }
        System.out.println();
    }

    public Integer getMin(){
        Stack<Integer> copy = (Stack<Integer>) stack.clone();
        while(!copy.isEmpty()){
            MIN = Math.min(copy.pop(), MIN);
        }
        return MIN;
    }

    public Integer pop() {
        return this.stack.pop();
    }

    public void push(Integer e){
        this.stack.push(e);
    }
}
