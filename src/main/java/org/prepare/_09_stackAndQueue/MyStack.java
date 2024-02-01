package org.prepare._09_stackAndQueue;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.spi.LocaleNameProvider;

/**
 * Queue로 Stack 만들기
 */
public class MyStack<T> {

    private Queue<T> inqueue;
    private Queue<T> dequeue;

    public Integer size() {
        return this.inqueue.size();
    }

    public MyStack(){
        this.inqueue = new LinkedList<>();
        this.dequeue = new LinkedList<>();
    }

    public void push(T element) {
        this.inqueue.offer(element);
    }

    public T pop() {
        if(inqueue.isEmpty()) return null;
        while(inqueue.size() > 1){
            dequeue.offer(inqueue.poll());
        }
        T value = inqueue.poll();
        inqueue = dequeue;
        dequeue = new LinkedList<>();
        return value;
    }
}
