/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 * 
 * 动态规划五部曲：
 * 确定dp数组以及下标的含义
 * 确定递推公式
 * dp数组如何初始化
 * 确定遍历顺序
 * 举例推导dp数组
 */

// @lc code=start
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        // 确定dp数组以及下标的含义：dp[i] 表示nums[i] 结尾的、且长度大于等于 3 的连续等差数列的个数
        int[] dp = new int[len];
        int res = 0;
        // 确定遍历顺序：从下标 2 开始，才有可能构成长度至少大于等于 3 的等差数列
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {// 判断条件：等差数组的定义
                // 递推公式：如果 nums[i] 能够接在 nums[i - 1] 之后形成一个长度更长且连续的等差数列，那么 dp[i] = dp[i - 1] + 1
                dp[i] = dp[i - 1] + 1;
                res += dp[i];// 结果收集
            }
        }
        return res;
    }
}
// @lc code=end
