/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 * 
 * 动态规划的股票交易问题
 * 理论上是188的简化
 */

// @lc code=start
// //进行一个实验,确实可以，但效率很低
// /* Your runtime beats 21.79 % of java submissions
//  * Your memory usage beats 5.03 % of java submissions (67.2 MB)
//  */
// class Solution {
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         if (len <= 1) {
//             return 0;
//         }
//         int k = Math.min(2, len / 2);// 一次交易涉及一天买入一天卖出，故总交易次数最大为天数一半

//         int[][][] dp = new int[len][2][k + 1];
//         // 第i天交易了k次时的最大利润，其中j代表当天是否持有股票，0不持有，1持有，数组依次代表天数、是否持有股票的状态、交易次数
//         // 第0天的初始化
//         for (int i = 0; i <= k; i++) {
//             dp[0][0][i] = 0; // 不持有股票时
//             dp[0][1][i] = -prices[0]; // 持有股票时
//         }
//         // 状态方程与遍历
//         for (int i = 1; i < len; i++) {
//             for (int j = 1; j <= k; j++) {
//                 dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
//                 // 当天不持有股票时，看前一天的股票持有情况：不动与买入
//                 dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
//                 // 当天持有股票时，看前一天的股票持有情况：不动与卖出
//             }
//         }
//         return dp[len - 1][0][k];
//     }
// }

//空间优化后的
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[5];
        // i表示第i天，j为 [0 - 4] 五个状态，dp[i][j]表示第i天状态j所剩最大现金
        // 五个状态01234对应 没有操作 第一次买入 第一次卖出 第二次买入 第二次卖出
        dp[1] = -prices[0];// 初始化，不说了，总之是买入
        dp[3] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 分别与没操作的相比
            dp[1] = Math.max(dp[1], dp[0] - prices[i]); // 买入
            dp[2] = Math.max(dp[2], dp[1] + prices[i]); // 卖出
            dp[3] = Math.max(dp[3], dp[2] - prices[i]); // 买入
            dp[4] = Math.max(dp[4], dp[3] + prices[i]); // 卖出
        }

        return dp[4];
    }
}
/*
 * 高了不少
 * Your runtime beats 70.12 % of java submissions
 * Your memory usage beats 26.05 % of java submissions
 */
// @lc code=end
