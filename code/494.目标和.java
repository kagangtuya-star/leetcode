/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 * 01背包——装满容量为x背包，有几种方法
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((target + sum) % 2 != 0) { // 向下取整影响，无解
            return 0;
        }

        int size = (target + sum) / 2;
        if (size < 0) {// target的绝对值大于sum，无解
            size = -size;
        }

        int[] dp = new int[size + 1];// 填满j（包括j）这么大容积的包，有dp[i]种方法
        dp[0] = 1;// 初始化：装满容量为0的背包，有1种方法，就是装0件物品，其他都为0即可
        for (int i = 0; i < nums.length; i++) {// nums放在外循环，target在内循环，且内循环倒序
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        /*
         * 不考虑nums[i]的情况下，填满容量为j - nums[i]的背包，有dp[j - nums[i]]种方法。
         * 那么只要搞到nums[i]的话，凑成dp[j]就有dp[j - nums[i]] 种方法。
         * 举个例子例如：dp[j]，j 为5，
         * 已经有一个1（nums[i]） 的话，有 dp[4]种方法 凑成 dp[5]。
         * 已经有一个2（nums[i]） 的话，有 dp[3]种方法 凑成 dp[5]。
         * 已经有一个3（nums[i]） 的话，有 dp[2]中方法 凑成 dp[5]
         * 已经有一个4（nums[i]） 的话，有 dp[1]中方法 凑成 dp[5]
         * 已经有一个5 （nums[i]）的话，有 dp[0]中方法 凑成 dp[5]
         * 那么凑整dp[5]有多少方法呢，也就是把 所有的 dp[j - nums[i]] 累加起来。
         */
        return dp[size];
    }
}
/*
 * Your runtime beats 94.22 % of java submissions
 * Your memory usage beats 31.56 % of java submissions (39.7 MB)
 */
// @lc code=end
