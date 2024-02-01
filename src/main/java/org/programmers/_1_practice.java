package org.programmers;

import java.util.Arrays;
import java.util.List;

/**
 * 핸드폰 키패드 왼손 오른손 찾기
 */
public class _1_practice {

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int leftPos = 0;
        int rightPos = 0;

        int[] left = {1,4,7};
        int[] right = {3,6,9};
        int[][] c = {
                {3,1},
                {0,0},{0,1},{0,2},
                {1,0},{1,1},{1,2},
                {2,0},{2,1},{2,2},
        };

        for(int i=0; i<numbers.length; i++){
            int number = numbers[i];
            if(number == 1 || number == 4 || number == 7){
                answer += "L";
                leftPos = number;
            }else if(number == 3 || number == 6 || number == 9){
                answer += "R";
                rightPos = number;
            }else{
                // 2,5,8,0
                // (0,0) (0,1)  (0,2)
                // (1,1)
                // (1,2)
                // (1,3)
                int[] leftCood = c[leftPos];
                int[] rightCood = c[rightPos];
                double leftVal = Math.abs(c[number][0] - leftCood[0])
                        + Math.abs(c[number][1] - leftCood[1]);
                double rightVal =Math.abs(c[number][0] - rightCood[0])
                        + Math.abs(c[number][1] - rightCood[1]);

                if(leftVal == rightVal){
                    if(hand.equals("right")){
                        answer += "R";
                        rightPos = number;
                    }else{
                        answer += "L";
                        leftPos = number;
                    }
                }else if(leftVal > rightVal){
                    answer += "R";
                    rightPos = number;
                }else{
                    answer += "L";
                    leftPos = number;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = solution(numbers, hand);
        System.out.println(result.equals("LRLLLRLLRRL"));
        //LRLLLRLLRRL
    }
}
