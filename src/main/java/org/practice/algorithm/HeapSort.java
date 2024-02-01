package org.practice.algorithm;

import java.util.PriorityQueue;

public class HeapSort {
    public static void heapSortMethod(int[] arr){
        PriorityQueue<Integer> h = new PriorityQueue<>();
        // 모든 원소를 차례대로 힙에 삽입
        for(int i=0; i< arr.length; i++){
            h.offer(-arr[i]); // 내림차순
        }
        // 힙에 삽입된 모든 원소를 차례대로 꺼내어 출력
        while(!h.isEmpty()){
            System.out.print(-h.peek()+" ");
            h.poll();
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,3,1,2,5,6,8};
        heapSortMethod(arr);
    }
}
