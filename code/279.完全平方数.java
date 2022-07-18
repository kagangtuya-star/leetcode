/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 * 
 * 动态规划
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // dp数组含义：dp[n]的值就是当给出整数为n时，和为 n 的完全平方数的最少数量 默认初始化值都为0

        for (int i = 1; i <= n; i++) {//正向遍历
            dp[i] = i; // 最坏的情况：每次都没找到，+1

            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); 
            }
            /*递推公式含义：
            找到n前面最大的一个完全平方数K，记为一个个数；
            那么 还剩n-K*K, 也就是说只要将n-k*k的解dp[n-k*k]
            加上上面那个1，就是n的解
             * 
             */

        }
        return dp[n];
    }
}
// @lc code=end
