/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 * 
 * 动态规划
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];// dp[i]表示i之前包括i的最长上升子序列的长度
        Arrays.fill(dp, 1);// 每一个i，对应的dp[i]（即最长上升子序列）起始大小至少都是是1.
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {// 从前向后遍历
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);// 位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值。
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end
