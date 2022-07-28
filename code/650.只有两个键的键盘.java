import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=650 lang=java
 *
 * [650] 只有两个键的键盘
 * 
 * 使用动态规划
 * 
 * 暴力的过程无非是深度优先遍历，每一次我们可以做两种选择：1. 复制当前所有字符；2. 粘贴剪切板的字符。
 * 所以，我们在暴力深搜的过程中需要记录 当前有多少字符 以及 剪切板有多少个字符
 */

// @lc code=start
class Solution {
    int inf = 10000; // 最大范围

    public int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        // dp[i][j]表示当前字符为 i 个，剪切板字符为 j 个时的最小操作次数

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], inf);// 初始化，填充为最大值,之后对初始的两个值定义
        }
        dp[1][0] = 0;// dp[1][0]=0表示初始时只有一个字符，还未做任何操作
        dp[1][1] = 1;// dp[1][1]=1表示复制一次操作

        for (int i = 2; i <= n; i++) {
            int min = inf;
            for (int j = 1; j <= i; j++) {
                if (i != j) {// 粘贴
                    dp[i][j] = dp[i - j][j] + 1;
                    min = Math.min(min, dp[i][j]);
                } else {// 复制
                    dp[i][j] = min + 1;
                }
            }
        }
        return IntStream.of(dp[n]).min().getAsInt();
    }
}
// @lc code=end
