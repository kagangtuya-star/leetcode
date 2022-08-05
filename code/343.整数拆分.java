/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        //d[]为正整数i拆分之后的最大乘积

        dp[2] = 1;// 从2开始的初始化，1不能拆分

        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i - 1; ++j) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                /*
                 * 把i拆分为j和i-j两个数相乘，
                 * j * dp[i-j]表示把i拆分成j和继续把(i-j)这个数拆分
                 * 取(i-j)拆分结果中的最大乘积与j相乘
                 */
            }
        }
        return dp[n];
    }
}
// @lc code=end
