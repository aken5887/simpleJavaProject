package org.practice.programmers;

/**
 * 배열의 같은 위치의 합 배열 구하기
 */
public class _2_practice {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][];

        for(int i=0; i<arr1.length; i++){
            int[] arr1arr = arr1[i];
            int[] arr2arr = arr2[i];
            int[] answerArr = new int[arr1arr.length];
            for(int j=0; j<arr1arr.length; j++){
                answerArr[j] = arr1arr[j]+arr2arr[j];
            }
            answer[i] = answerArr;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
