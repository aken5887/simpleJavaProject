package org.backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Boj 7568 덩치
 */
public class Boj_7568_BigBodyRank {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String tmp = "";
        int index = 0;
        int N = 0;
        String[] person = {};
        while((tmp = bf.readLine()) != null){
            if(index == 0){
                N = Integer.parseInt(tmp);
                person = new String[N];
                index++;
            } else {
                person[index-1] = tmp;
                index++;
            }
        }

        for(int i=0; i< person.length; i++){
            int[] person1 = getHeightWeight(person[i]);
            int rank = 1;
            for(int j=0; j < person.length; j++){
                if(i == j) continue;
                int[] person2 = getHeightWeight(person[j]);
                if(person1[0] < person2[0] && person1[1] < person2[1]){
                    rank++;
                }
            }
            System.out.print(rank+" ");
        }
    }

    private static int[] getHeightWeight(String person){
        int[] record = new int[2];
        record[0] = Integer.parseInt(person.split(" ")[0]);
        record[1] = Integer.parseInt(person.split(" ")[1]);
        return record;
    }
}
