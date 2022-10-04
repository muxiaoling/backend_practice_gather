package com.algorithm.dp;


//完全背包
public class Bag_Question2 {
    public static void main(String[] args) {
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        int m = weight.length;
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }


            for (int t = 0; t <= bagWeight; t++) {
                System.out.print(dp[t] + " ");
            }
            System.out.println();
        }
    }
}
