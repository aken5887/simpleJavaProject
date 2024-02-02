package org.practice.handcoding;

/**
 * Array에서 index와 값이 일치하는 index 찾기(정렬된 배열)
 * 1. 예시로 -10, -4, -3, -1, 0, 1, 4, 7, 10, 13, 15 이런식이면 7이 답
 */
public class FIndArrayMatchingIndex {
    public static void main(String[] args) {
        int[] arr = {-10, -4, -3, -1, 0, 1, 4, 7, 10, 13, 15};
        for(int i=0; i < arr.length; i++){
            if(i == arr[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
