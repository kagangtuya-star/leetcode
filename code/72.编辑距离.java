/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 * 
 * https://leetcode.cn/problems/edit-distance/solution/dai-ma-sui-xiang-lu-72-bian-ji-ju-chi-do-y87e/
 * 动态规划问题-四个递推公式
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        // dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        /*
         * 初始化：
         * dp[i][0] ：以下标i-1为结尾的字符串word1，和空字符串word2，最近编辑距离为dp[i][0]
         * 那么dp[i][0]就应该是i，对word1里的元素全部做删除操作，即：dp[i][0] = i
         * dp[0][j]同理
         */

        for (int i = 1; i <= m; i++) {
            // dp[i][j]是依赖左方，上方和左上方元素,一定是从左到右 从上到下去遍历,见图
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];// 不编辑
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    // 分别对应 添加（矩阵数组变动：右下方移动） 增（右移动） 删（下方移动）
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end
