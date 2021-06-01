package Exam.Amazon;

import java.util.ArrayList;
import java.util.Arrays;

public class maxProfitKTransaction {
    public static void main(String[] args) {
        int[] array={3,2,6,5,0,3};
        System.out.println( maxProfit(2,array));
        ArrayList<Integer> nums=new ArrayList<Integer>();
    }
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >=  n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int localMax =- prices[0];
            for (int j = 1; j < n; j++) {
                //System.out.println(localMax);
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
     System.out.println(Arrays.deepToString(dp));
        return dp[k][n-1];
    }
}
