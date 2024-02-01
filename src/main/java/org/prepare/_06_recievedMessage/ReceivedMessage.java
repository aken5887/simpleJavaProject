package org.prepare._06_recievedMessage;

public class ReceivedMessage {
    public static void main(String[] args) {
        ReceivedMessage rm = new ReceivedMessage();
        int[] arr = {6, 9, 5, 7, 4};
        int[] result = rm.solution(arr);
        rm.printIntArr(arr);
        rm.printIntArr(result);
    }

    private void printIntArr(int[] arr){
        System.out.print("[ ");
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.print("]\n");
    }

    private int[] solution(int[] arr){
        int[] result = new int[arr.length];
        for(int i=arr.length-1; i>=1; i--){
            for(int j=i-1; j>=0; j--){
                if(arr[i] < arr[j]){
                    result[i] = j+1;
                    break;
                }
            }
        }
        return result;
    }
}
