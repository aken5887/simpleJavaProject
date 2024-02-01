package org.prepare._09_stackAndQueue;

import java.util.Stack;

/**
 * Stack만 이용해서 Queue를 구현해보기
 * @param <T>
 */
public class MyQueue<T>{
    private final Stack<T> instack;
    private final Stack<T> outstack;

    public MyQueue() {
        this.instack = new Stack<>();
        this.outstack = new Stack<>();
    }

    public Integer size() {
        return this.instack.size() + this.outstack.size();
    }

    public void push(T element) {
        this.instack.push(element);
    }

    public T poll() {
//        if(instack.isEmpty()) return null;
//        T value = this.instack.get(0);
//        this.instack.remove(0);
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
        }
        if(outstack.isEmpty()) return null;
        return outstack.pop();
    }

}
