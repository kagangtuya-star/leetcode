/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 * 动态规划-股票交易问题
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // /*
        //  * 创建二维数组，用来代表三种状态 
        //  * dp[i][0]：持有股票
        //  * dp[i][1]：不持有股票，处于冷冻期
        //  * dp[i][2]：不持有股票，不处于冷冻期
        //  */
        // int[][] dp = new int[prices.length][3];

        // // 第一天如果持有股票，利润肯定是 -prices[0]
        // dp[0][1] = -prices[0];

        // for (int i = 1; i < prices.length; i++) {
        //     //当天是非冷冻期，前一天不可能持有股票
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        //     //当天持有股票，前一天不可能是冷冻期，也就没有dp[i-1][1]
        //     dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
        //     //当天是冷冻期，只可能是前一天持有股票，然后今天卖出股票了
        //     dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0]);
        // }
        // // 返回最后一天没有持有股票的最大利润
        // return dp[prices.length - 1][0];

        //优化版本 用一个临时的变量保存dp0
        int dp0 = 0,dp1 = -prices[0],dp2 = 0;
        for(int price : prices){
            int temp = dp0;
            dp0 = Math.max(dp0,dp1 + price);
            dp1 = Math.max(dp1,dp2 - price);
            dp2 = Math.max(dp2,temp);
        }
        return dp0;
    }
}
// @lc code=end
