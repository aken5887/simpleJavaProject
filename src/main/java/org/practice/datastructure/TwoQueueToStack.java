package org.practice.datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TwoQueueToStack {
    private Queue<Integer> inqueue = new LinkedList<>();
    private Queue<Integer> outqueue = new LinkedList<>();

    public void push(Integer number) {
        inqueue.offer(number);
    }

    public Integer pop(){
        while(inqueue.size() > 1){
            outqueue.offer(inqueue.poll());
        }
        Integer number = inqueue.poll();
        inqueue = outqueue;
        outqueue = new LinkedList<>();
        return number;
    }

    public static void main(String[] args) {
        TwoQueueToStack stack = new TwoQueueToStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop() == 3);

        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop() == 6);
    }
}
