/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];// dp[i][j]表示 text1[0:i-1] 和 text2[0:j-1] 的最长公共子序列

        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);// 当 i = 0 时：dp[0][j]=0;当 j = 0 时：dp[i][0]=0
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } /*
                   * 当text1[i - 1] == text2[j - 1]时：dp[i][j] = dp[i - 1][j - 1] + 1
                   * 当text1[i - 1] != text2[j - 1]时：dp[i][j] = Math.max(dp[i - 1][j], dp[i][j -
                   * 1]);
                   */
            }
        }
        return dp[m][n];
    }
}
// @lc code=end
