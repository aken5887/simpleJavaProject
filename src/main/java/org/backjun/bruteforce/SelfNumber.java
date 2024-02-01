package org.backjun.bruteforce;

public class SelfNumber {
    public static void main(String[] args){

        boolean[] arr = new boolean[10001];
        final int END_RANGE = 10_000;

        for(int i=1; i<=END_RANGE; i++){
            int number = i;
            int temp = 0;
            String numStr = String.valueOf(i);
            for(char c:numStr.toCharArray()){
                temp += c-'0';
            }
            number = number + temp;
            if(number <= END_RANGE) {
                arr[number] = true;
            }
        }

        for(int i=1; i<=END_RANGE; i++){
            if(!arr[i]){
                System.out.println(i);
            }
        }
    }
}
