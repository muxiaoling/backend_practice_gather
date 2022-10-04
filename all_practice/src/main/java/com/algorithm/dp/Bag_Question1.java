package com.algorithm.dp;


//01背包
public class Bag_Question1 {
    public static void main(String[] args) {
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        int m = weight.length;
        int bagWeight = 4;
        int[][] dp = new int[m][bagWeight + 1];
        for (int i = 0; i <= bagWeight; i++) {
            if (weight[0] <= i) dp[0][i] = value[0];
            System.out.print(dp[0][i] + " ");
        }
        System.out.println();
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weight[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}

