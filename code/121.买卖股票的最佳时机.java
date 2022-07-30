/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 * 
 * 动态规划
 */

// @lc code=start
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;

        // 特殊判断
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][2];// dp数组：第i天结束时，手上持股情况为j（1为持股，0为不持股）的现金数

        // 初始化
        dp[0][0] = 0;// 不持股为 0
        dp[0][1] = -prices[0];// 持股减去第1天的股价

        // 从第 2 天开始
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            /*
             * 第i天不持股，则有两种情况，取最大值
             * 1.第i-1天持股，今天什么也不做 dp[i - 1][0]
             * 2.第i-1天持股，今天卖出 dp[i - 1][1] + prices[i]
             */
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            /*
             * 类似的，第i天持股则有如下两种，取最大值
             * 1. 昨天持股，今天什么都不做 dp[i - 1][1]
             * 2. 昨天不持股，今天买入股票 -prices[i]
             */
        }
        /*
         * 此处有优化空间的算法
         * int[][] dp = new int[2][2];
         * for (int i = 1; i < len; i++) {
         * dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
         * dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], -prices[i]);
         * }
         */

        return dp[len - 1][0];
        // 返回最后一天的
    }
}
// @lc code=end
