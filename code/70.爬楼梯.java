/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 * 一维动态规划问题
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];// 定义一个一维数组来记录不同楼层的状态，dp[i]： 爬到第i层楼梯，有dp[i]种方法
        dp[0] = 1;// dp[0]没有实际意义，作为起始媒介使用
        dp[1] = 1;
        for (int i = 2; i <= n; i++) { // 上楼梯
            dp[i] = dp[i - 1] + dp[i - 2];// 确定递推公式：
            /*
             * 首先是dp[i - 1]，上i-1层楼梯，有dp[i - 1]种方法，
             * 那么再一步跳一个台阶不就是dp[i]了么。还有就是dp[i - 2]，
             * 上i-2层楼梯，有dp[i - 2]种方法，那么再一步跳两个台阶不就是
             * dp[i]了么。那么dp[i]就是 dp[i - 1]与dp[i - 2]之和！所以d
             * p[i] = dp[i - 1] + dp[i - 2]
             * 
             */
        }
        return dp[n];

    }
}
// @lc code=end
