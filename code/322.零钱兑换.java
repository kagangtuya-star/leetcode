/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 * 
 * 完全背包问题
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE; // int类型最大数 2147483647
        int[] dp = new int[amount + 1];// 凑足总额为j所需钱币的最少个数为dp[j]
        // 初始化dp数组数值为最大值
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        // 但当金额为0时，需要的硬币数为0
        dp[0] = 0;

        // 钱币有顺序和没有顺序都可以，都不影响钱币的最小个数，则本题并不强调集合是组合还是排列
        // 无论内层遍历背包还是外层遍历背包都是可以的，又完全背包。所以遍历的内循环是正序
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {// 其初始初始最大值
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    /*
                     * 得到dp[j]（考虑coins[i]），只有一个来源，dp[j - coins[i]]
                     * 凑足总额为j - coins[i]的最少个数为dp[j - coins[i]]，
                     * 那么只需要加上一个钱币coins[i]即dp[j - coins[i]] + 1就是dp[j]
                     * 所以dp[j] 要取所有 dp[j - coins[i]] + 1 中最小的
                     */
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
// @lc code=end
