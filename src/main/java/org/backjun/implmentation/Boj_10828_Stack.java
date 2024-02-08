package org.backjun.implmentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10828 스택
 * author         : choi
 * date           : 2024-02-08
 */
public class Boj_10828_Stack {

    static class BojStack {
        private int[] arr;
        private int lastIndex = -1;
        public BojStack(){
            this.arr = new int[10_000];
        }

        public void push(int value){
            lastIndex++;
            arr[lastIndex] = value;
        }

        public int pop(){
            if(lastIndex == -1){
                return -1;
            }
            else{
                int value = arr[lastIndex];
                arr[lastIndex] = 0; // 초기화
                lastIndex = Math.max(-1, lastIndex-1); // lastIndex 초기화
                return value;
            }
        }

        public Integer size() {
            return lastIndex + 1;
        }

        public Integer empty(){
            if(lastIndex == -1) {
                return 1;
            } else {
                return 0;
            }
        }

        public int top(){
            if(lastIndex == -1) {
                return -1;
            } else{
                return arr[lastIndex];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        BojStack bojStack = new BojStack();
        for(int i=0; i<N; i++){
            String message = bf.readLine();
            int input = 0;
            if(message.startsWith("push")){
                input = Integer.parseInt(message.split(" ")[1]);
                message = "push";
            }
            switch (message){
                case "push":
                    bojStack.push(input);
                    break;
                case "pop":
                    System.out.println(bojStack.pop());
                    break;
                case "top":
                    System.out.println(bojStack.top());
                    break;
                case "size":
                    System.out.println(bojStack.size());
                    break;
                case "empty":
                    System.out.println(bojStack.empty());
                    break;
            }
        }
    }
}
