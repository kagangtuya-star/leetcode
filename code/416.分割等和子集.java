/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 * 01背包问题
 * 背包的体积为sum / 2
 * 背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
 * 背包如果正好装满，说明找到了总和为 sum / 2 的子集。
 * 背包中每一个元素是不可重复放入
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {

        // dp[j]表示 背包总容量是j，最大可以凑成j的子集总和为dp[j]。
        if (nums == null || nums.length == 0)
            return false;
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        // 总和为奇数，不能平分
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        // 如果使用一维dp数组，物品遍历的for循环放在外层，遍历背包的for循环放在内层，且内层for循环倒序遍历
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // 每一个元素一定是不可重复放入，所以从大到小遍历
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
// @lc code=end
