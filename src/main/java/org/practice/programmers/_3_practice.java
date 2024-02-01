package org.practice.programmers;

/**
 * 소수 찾기
 */
public class _3_practice {
    public static int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n+1];

        for(int i=2; i<=n; i++){
            isPrime[i] = true;
        }

        for(int i=2; i*i<=n; i++){
            for(int j = i*i; j<=n; j+=i){
                isPrime[j] = false;
            }
        }

        for(int i=1; i<=n ; i++){
            if(isPrime[i]) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));;
    }
}
