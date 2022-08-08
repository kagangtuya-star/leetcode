/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);// 按数组第一位排序

        int ans = 0;// 返回值
        int[] dp = new int[1000];// dp[i] 表示长度i+1的数链的最小结尾
        Arrays.fill(dp, Integer.MAX_VALUE);// 初始化填充 全最大

        for (int i = 0; i < pairs.length; i++) {// 遍历以第i个打头的数对
            int[] pair = pairs[i];
            int c = pair[0], v = pair[1], j = 0;// 此次遍历数组的头，第二位以及临时计数器
            // 遍历找j ， pairs[i]能达到的最大长度-1
            while (j < dp.length && c > dp[j]) {
                j++;
            }
            if (v < dp[j]) {
                dp[j] = v;
                ans = Math.max(ans, j);
            }
        }
        return ans + 1;
    }
}
// @lc code=end
