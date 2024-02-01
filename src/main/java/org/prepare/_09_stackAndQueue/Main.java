package org.prepare._09_stackAndQueue;

import java.util.*;

public class Main<T> {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        while(myQueue.size() > 0){
            System.out.println(myQueue.poll());
        }
        System.out.println(myQueue.poll());

        MyStack<String> myStack = new MyStack<>();
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");

        while(myStack.size() > 0){
            System.out.println(myStack.pop());
        }
        System.out.println(myStack.pop());


        String a = "..a...";
        System.out.println(a.replaceAll("..","."));
    }

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] arr = {"code", "date", "maximum", "remain"};
        List<String> columnList = Arrays.asList(arr);
        int extIdx = columnList.indexOf(ext);
        int sortIdx = columnList.indexOf(sort_by);
        int[][] answer =
                (int[][]) Arrays.stream(data)
                        .filter(o1 -> o1[extIdx] < val_ext)
                        .sorted((o1, o2) -> o1[sortIdx] - o2[sortIdx])
                        .toArray();
        return answer;
    }
}
