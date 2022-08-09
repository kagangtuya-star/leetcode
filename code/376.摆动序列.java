/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        } // 空的或者只有一个其最大摆动序列就是自己

        // 当前差值
        int curDiff = 0;
        // 上一个差值
        int preDiff = 0;

        int count = 1;
        /*
         * 局部最优：删除单调坡度上的节点（不包括单调坡度两端的节点），那么这个坡度就可以有两个局部峰值。
         * 整体最优：整个序列有最多的局部峰值，从而达到最长摆动序列
         * 
         * 让峰值尽可能的保持峰值，然后删除单一坡度上的节点
         */
        for (int i = 1; i < nums.length; i++) {
            // 得到当前差值
            curDiff = nums[i] - nums[i - 1];
            // 如果当前差值和上一个差值为一正一负
            // 等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}

// @lc code=end
