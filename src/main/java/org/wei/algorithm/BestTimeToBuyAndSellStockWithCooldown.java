package org.wei.algorithm;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        int[] prices ={};
        System.out.println(new Solution().maxProfit(prices));
    }

    /**
     * 了解从哪个状态转移而来
     * dp[i][0] 我们目前持有一支股票：1.前一天持有  2.前一天购买
     * dp[i][1] 我们目前不持有任何股票，并且处于冷冻期中：1.前一天购买持有
     * dp[i][2] 们目前不持有任何股票，并且不处于冷冻期中：1.前一天冷冻期 2.前一天不买
     * 当前只有三种状态 可以推断从上面三种状态过来
     *
     * */
   static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int len = prices.length;
            int[][] dp= new int[len][3];
            dp[0][0] = -prices[0];
            for (int i = 1; i < len; i++) {
                //当前买入
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
                dp[i][1] = dp[i-1][0]+prices[i];
                dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
            }
            return Math.max(dp[len-1][1],dp[len-1][2]);
        }
    }
}
