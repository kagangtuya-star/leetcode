/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 * 
 * 又一个动态规划股票问题
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        // int n = prices.length;
        // int[][] dp = new int[n][2];
        // // 第n天，股票持有状态为j时能够获取的最大利润，j只有两个值0与1，不持有/持有

        // dp[0][0] = 0;// 初始化：第0天不持有自然为0
        // dp[0][1] = -prices[0];// 第一天持有买入了则减去股票价钱

        // for (int i = 1; i < n; i++) {// 股票问题全是正向遍历
        // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
        // /*
        // * 第i天没持有，两种情况
        // * 对应前一天也没动静 dp[i - 1][0]
        // * 或前一天卖出了，但需要减去手续费
        // */
        // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        // /*
        // * 第i天持有，两种情况
        // * 对应前一天也没动静 dp[i - 1][0]
        // * 或前一天买入（这个没手续费）
        // */
        // }
        // return dp[n - 1][0];

        // 优化空间结构：转移的时候，dp[i]只会从 dp[i-1]转移得来，第一维可以去掉，即直接采用数组的值
        int n = prices.length;
        int[] dp = new int[2];

        dp[0] = 0;
        dp[1] = -prices[0];

        for (int i = 1; i < n; i++) {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], tmp - prices[i]);
        }
        return dp[0];
    }
}
// @lc code=end
