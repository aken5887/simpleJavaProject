package org.programmers;

import java.util.*;

public class _12_practice {

    public static void main(String[] args) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int[] a = new int[]{1,2};
        int[] b = new int[]{0,1};
        pq.offer(a);
        pq.offer(b);

        System.out.println(pq.peek()[0]);
    }
    public static int solution(int[] order) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<=order.length; i++){
            que.offer(i);
        }

        for(int i=0; i<order.length; i++){

            if(!stack.isEmpty() &&
                    stack.peek() == order[i]){
                stack.pop();
                answer++;
                continue;
            }

            if(que.peek() == order[i]){
                que.poll();
                answer++;
                continue;
            } else {
                stack.push(que.poll());
                continue;
            }
        }
        return answer;
    }
}
