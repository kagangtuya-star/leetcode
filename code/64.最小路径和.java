/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 * 
 * 二维路径规划问题
 * 
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;// 竖列
        int col = grid[0].length;// 横排
        int[][] dp = new int[row][col];// 定义：dp是个矩阵，dp[i][j]代表直到走到(i,j)的最小路径之和
        dp[0][0] = grid[0][0];// 对左上角的第一个值初始化

        if (grid == null || grid.length == 9 || grid[0].length == 0) {
            return 0;// 空值检定
        }
        // copy数组
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];// 一直向下走
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];// 一直向右走
        }
        // 递归公式
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                /*
                 * 走到当前单元格 (i,j)的最小路径为从左方单元格与从上方单元格走来的
                 * 两个最小路径和中较小的加上当前单元格值
                 */
            }
        }

        return dp[row - 1][col - 1];

    }
}
// @lc code=end
