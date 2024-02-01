package org.practice.algorithm;

public class Main {

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        String parkElement = park[0];
        int xPos = parkElement.indexOf("S");
        int yPos  = 0;
        int xMax =parkElement.length();
        int yMax =  park.length;

        answer[0] = xPos;
        answer[1] = yPos;
        for(int i=0; i<routes.length; i++){
            String route = routes[i];
            String direction = String.valueOf(route.charAt(0));
            int move = Integer.parseInt(String.valueOf(route.charAt(2)));
            boolean change = true;

            switch(direction){
                case "E":
                    while(yMax > yPos && move > 0){
                        yPos++;
                        move--;
                        change = validPos(xPos, yPos, park);
                        if(!change) break;
                    }
                    break;
                case "W":
                    while(yPos > 0  && move > 0){
                        yPos--;
                        move--;
                        change = validPos(xPos, yPos, park);
                        if(!change) break;
                    }
                    break;
                case "S":
                    while(xMax > xPos  && move > 0){
                        xPos++;
                        move--;
                        change = validPos(xPos, yPos, park);
                        if(!change) break;
                    }
                    break;
                case "N":
                    while(xPos > 0  && move > 0){
                        xPos--;
                        move--;
                        change = validPos(xPos, yPos, park);
                        if(!change) break;
                    }
                    break;
            }
            if(change){
                answer[0] = xPos;
                answer[1] = yPos;
            }
        }

        return answer;
    }

    private static boolean validPos(int xPos, int yPos, String[] park){
        if(String.valueOf(park[xPos].charAt(yPos)).equals("O")
            || String.valueOf(park[xPos].charAt(yPos)).equals("S")){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Main main = new Main();

        String[] a = {"SOO", "OXX", "OOO"};
        String[] b = {"E 2", "S 2", "W 1"};
        int[] r = main.solution(a,b);
        System.out.println(r[0]+","+r[1]);
    }
}
