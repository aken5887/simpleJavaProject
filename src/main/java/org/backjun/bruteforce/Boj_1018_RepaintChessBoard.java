package org.backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 1018번 체스판 다시 칠하기
 */
public class Boj_1018_RepaintChessBoard {
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for(int i=0; i<arr.length; i++){
            arr[i] = br.readLine();
        }
        br.close();
        System.out.println(count(arr));
    }

    private static int count(String[] arr){
        int result = Integer.MAX_VALUE;
        // 경우의 수는 N-7 만큼 존재
        // N = 8 일때 1번, N = 9 이면 2번 탐색 가능
        for(int i=0; i < N-7; i++){
            // 세로도 마찬가지, 경우의 수 M-7 만큼 존재
            for(int j=0; j < M-7; j++){
                // 시작이 흰색인 경우 검은색 인경우 2가지 경우의 수 존재
                for(int k=0; k<2; k++){
                    char start = k == 0 ? 'W' : 'B'; // 시작 점
                    int count = 0;
                    for(int n=i; n < i+8; n++){
                        for(int m=j; m < j+8 ; m++){
                            if(start != arr[n].charAt(m)){
                                count++;
                            }
                            start = start == 'W'?'B':'W';
                        }
                        // 전 행의 마지막 열의 값에서 다시 뒤집어 줌
                        start = start == 'W'?'B':'W';
                    }
                    result = Math.min(count, result);

                    if(result == 0) return 0; // 0의 경우의 수가 존재하는 경우 바로 리턴
                }

            }
        }
        return result;
    }
}
