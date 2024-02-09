package org.backjun.greedy;

import java.util.Scanner;

/**
 * 백준 1541 잃어버린 괄호
 * author         : choi
 * date           : 2024-02-09
 */
public class Boj_1541_LostBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int sum = 0;
        String[] subtractions = input.split("-");
        for(int i=0; i<subtractions.length; i++){
            int temp = 0;
           String[] addition = subtractions[i].split("\\+");
           for(int j=0; j<addition.length; j++){
               temp += Integer.parseInt(addition[j]);
           }
           if(i == 0){
               sum += temp;
           } else {
               sum -= temp;
           }
        }
        System.out.println(sum);
    }

}
