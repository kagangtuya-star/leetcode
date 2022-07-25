/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 * 
 * 双维度01背包问题
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // 最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
        int[][] dp = new int[m + 1][n + 1];
        int onenum; // 0与1的个数
        int zeronum;
        // 遍历物品统计0与1的个数
        for (String str : strs) {
            onenum = 0;
            zeronum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeronum++;
                } else {
                    onenum++;
                }
            }

            // 倒叙遍历 m n都是相当于以前01背包问题的一维背包遍历，必须要倒叙
            for (int i = m; i >= zeronum; i--) {
                for (int j = n; j >= onenum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeronum][j - onenum] + 1);
                    /* dp[i][j] 可以由前一个strs里的字符串推导出来,前一个有zeronum个0，oneenum个1 
                     */
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end
