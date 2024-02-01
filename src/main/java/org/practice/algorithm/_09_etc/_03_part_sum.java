package org.practice.algorithm._09_etc;

public class _03_part_sum {
    public static void main(String[] args) {
        int n = 5;
        int[] data = {10, 20, 30, 40, 50};
        int[] prefixSum = new int[n+1];

        // 접두사의 합 계산
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += data[i-1];
            prefixSum[i] = sum;
        }
        // 구간 합 계산 (2~4)
        int left = 1;
        int right = 4;
        System.out.println(prefixSum[right] - prefixSum[left]);
    }
}
