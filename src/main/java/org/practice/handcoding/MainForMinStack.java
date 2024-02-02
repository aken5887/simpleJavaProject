package org.practice.handcoding;

public class MainForMinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        System.out.println(minStack.getMin());
        MinStack minStack2 = new MinStack(100);
        System.out.println(minStack2.getMin());
    }
}
