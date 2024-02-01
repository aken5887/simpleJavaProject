package org.programmers;

import javax.print.attribute.standard.PresentationDirection;
import java.util.*;

/**
 * 레벨 1 공원 산책
 */
public class _8_practice {
    public int[] solution(String[] park, String[] routes) {
        int row = park.length;
        int column = park[0].length();
        int[] current = new int[2];
        for(int i=0; i<park.length; i++){
            if(park[i].indexOf("S")>0){
                current[0] = i;
                current[1] = park[i].indexOf("S");
            }
        }

        for(int i=0; i<routes.length; i++){
            String route = routes[i];
            String dir = route.substring(0,1);
            int mov = Integer.parseInt(route.substring(2,3));
            boolean pass = true;
            int drow = current[0]; // row
            int dcol = current[1]; // column

            for(int j=1; j<=mov; j++){
                switch(dir){
                    case "E":
                        dcol++;
                        break;
                    case "W":
                        dcol--;
                        break;
                    case "S":
                        drow++;
                        break;
                    default:
                        drow--;
                        break;
                }
                if( drow < 0 ||
                        drow > row-1 ||
                        dcol <0 ||
                        dcol > column-1 ||
                        String.valueOf(park[drow].charAt(dcol)).equals("X"))
                {
                    pass = false;
                    break;
                }
            }

            if(pass) {
                current[0] = drow;
                current[1] = dcol;
            }
        }

        return current;
    }

        public static void main(String[] args) {
//        String[] park = {"OSO","OOO","OXO","OOO"};
//        String[] routes = {"E 2","S 2","W 1"};
//        int[] result = new _8_practice().solution(park, routes);
//        System.out.println(result[0]+","+result[1]); //2,1

        String Y = "552";
        System.out.println(Y.replaceFirst("5", ""));
    }

    public int[] solution(int []arr) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }
        }

        int[] answer = new int[set.size()];
        Iterator itr = set.iterator();
        int idx = 0;
        while(itr.hasNext()){
            answer[idx] = (int) itr.next();
            idx++;
        }
        return answer;
    }
}


