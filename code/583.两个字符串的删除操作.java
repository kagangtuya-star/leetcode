/*
 * @lc app=leetcode.cn id=583 lang=java
 *
 * [583] 两个字符串的删除操作
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];// dp[i][j]表示w1的前i个字符与w2的前j个字符的最长公共子序列

        dp[0][0] = 0;// 初始化：两者相等，自然为0

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 1. 如果w1[i-1]==w2[j-1]，dp[i][j]=dp[i-1][j-1]+1
        // 当前位置相等，可以从前一位转移过来，同时，加上当前的一个字符长度
        // 2. 如果w1[i-1]!=w2[j-1]，dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j])
        // 不使用word2[j-1]，或者不使用word1[i-1]时的情况，而这两种情况之前已经计算过了，取其中的最大值转移过来

        return m + n - 2 * dp[m][n]; // 计算最终值
    }
}
// @lc code=end
/*
 * 执行用时：
 * 6 ms
 * , 在所有 Java 提交中击败了
 * 83.82%
 * 的用户
 * 内存消耗：
 * 42.3 MB
 * , 在所有 Java 提交中击败了
 * 21.65%
 * 的用户
 */
