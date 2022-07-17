/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int[][] dp = new int[M + 1][N + 1];// dp[i][j]表示以matrix[i][j]为右下角，且只包含1的正方形的边长的最大值
        int result = 0;

        if (matrix == null || matrix.length == 0) {
            return 0;
        } // 空值

        for (int i = 1; i <= M; i++) {// 一个个扫描计算对应的d[i][j]
            for (int j = 1; j <= N; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    continue;// 如果扫到的位置的值是0，直接到下一个，当前位置不可能符合题意
                }
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                // 递归公式：推导思路见https://leetcode.cn/problems/maximal-square/solution/jin-dao-dong-tai-gui-hua-you-hua-yydszui-ieqf/
                result = Math.max(result, dp[i][j]);// 筛选出最大的dp
            }
        }
        return result * result;// 求面积
    }
}
// @lc code=end
