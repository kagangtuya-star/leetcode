/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 * 
 * 由198的打家劫舍1思路修改而来
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } // 只有一间房间的话直接返回

        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        // 对应两种转化前的偷窃思路：不偷窃最后一间房间、不偷窃第一间房间，于是问题成了两个单排排列

        f[1] = nums[0]; // 初始化：只偷窃1号房间所能获得nums[0]
        g[2] = nums[1]; // 将第二间房间当成房间列的起点，只偷窃2号房间所能获得nums[1]

        for (int i = 2; i <= n - 1; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
        }
        for (int i = 3; i <= n; i++) {
            g[i] = Math.max(g[i - 1], g[i - 2] + nums[i - 1]);
        }
        /*
         * 两个子问题的排列思路是与198题一样的，主要是考虑最后一间偷还是不偷
         * 如果偷最后一间，则结果为偷窃1号到i- 1号房间所能获得的最高金额 f[i] = f[i-1]
         * 不偷的话（偷窃前i - 2间房间和最后一间房间），结果为偷窃1号到i- 2号房间所能获得的最高金额再加上偷窃第i号房间的金额，即f[i] = f[i
         * -2] + nums[i]
         */

        return Math.max(f[n - 1], g[n]);// 比较子问题答案选最大的即可
    }
}
// @lc code=end
/*
 * 75/75 cases passed (0 ms)
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 27.51 % of java submissions (39.1 MB)
 */
