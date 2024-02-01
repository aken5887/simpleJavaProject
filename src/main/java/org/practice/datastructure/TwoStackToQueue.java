package org.practice.datastructure;

import java.util.Stack;

public class TwoStackToQueue {
    private Stack<Integer> instack = new Stack<>();
    private Stack<Integer> outstack = new Stack<>();

    public void enqueue(Integer number){
        instack.push(number);
    }

    public Integer dequeue(){
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
        }
        return outstack.pop();
    }

    public static void main(String[] args) {
        TwoStackToQueue queue = new TwoStackToQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue() == 1);
        System.out.println(queue.dequeue() == 2);
        System.out.println(queue.dequeue() == 3);
        System.out.println(queue.dequeue() == 4);
        System.out.println(queue.dequeue() == null);
    }
}
