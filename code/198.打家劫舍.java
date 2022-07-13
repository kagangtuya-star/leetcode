/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 * 
 * 动态规划问题
 * 五部曲：
 * 确定dp数组以及下标的含义
 * 确定递推公式
 * dp数组如何初始化
 * 确定遍历顺序
 * 举例推导dp数组
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        //特值直接返回
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len + 1]; //数组含义：n号房间可以偷到的最大值
        dp[0] = 0; //
        dp[1] = nums[0];//初始化
        for (int i = 2; i <= len; i++) { //遍历顺序：从前向后 
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]); 
            /*递推数组：
             *对于{3 1 2 4 }， 1 号房间可盗窃最大值为 3，d[1]=3;2号房间最大为4，d[2]=4；3号房间本身为2，最大为5，
             *推理得d[3]=max(d[2],d[1]+2);
             *即dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]            */
        }
        return dp[len];
    }
}
// @lc code=end
