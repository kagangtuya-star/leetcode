/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 * 
 * 三维动态规划
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        k = Math.min(k, len / 2);// 一次交易涉及一天买入一天卖出，故总交易次数最大为天数一半

        int[][][] dp = new int[len][2][k + 1];
        // 第i天交易了k次时的最大利润，其中j代表当天是否持有股票，0不持有，1持有，数组依次代表天数、是否持有股票的状态、交易次数
        // 第0天的初始化
        for (int i = 0; i <= k; i++) {
            dp[0][0][i] = 0; // 不持有股票时
            dp[0][1][i] = -prices[0]; // 持有股票时
        }
        // 状态方程与遍历
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                // 当天不持有股票时，看前一天的股票持有情况：不动与买入
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
                // 当天持有股票时，看前一天的股票持有情况：不动与卖出
            }
        }
        return dp[len - 1][0][k];

    }
}
// @lc code=end
