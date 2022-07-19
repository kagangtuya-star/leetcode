/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 * 变种的动态规划
 * https://leetcode.cn/problems/decode-ways/solution/jie-ma-fang-fa-tu-jie-dp-zui-qing-xi-yi-97hng/
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 10];// dp[n]表示表示前n个数字一共有多少种解码方式

        dp[0] = 1;// 初始状态

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            } // 单独解码s[i - 1]

            if (i >= 2) {
                int t = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if (t >= 10 && t <= 26) {
                    dp[i] += dp[i - 2];
                } // 将s[i - 2] 和 s[i - 1]组合解码
            }
        }
        return dp[n];
    }
}
// @lc code=end
