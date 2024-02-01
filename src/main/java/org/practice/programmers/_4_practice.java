package org.practice.programmers;

public class _4_practice {
    public int solution(int[][] jobs) {
        int answer = 0;
        int currentJob = 0;
        boolean[] status = new boolean[jobs.length];
        // 시간이 많이 걸리는 것을 먼저 처리
        for(int i=0; i<jobs.length; i++){
            int[] job = jobs[i];
            int start = job[0];
            int time = job[1];
            currentJob += job[1];
        }
        return answer;
    }
}
