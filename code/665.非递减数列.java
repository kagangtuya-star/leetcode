/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        /*
         * 当后面的数字小于前面的数字产生冲突后
         * 考虑需要修改的数的三种情况：
         * 1.前面没有数字（第一位），直接修改即可
         * 2.前面存在数字，且比要修改的目标数小，直接修改即可；
         * 3.前面不仅存在数字，而且比要修改的目标数大，
         * 则修改为前面较大的数。
         * eg
         * 4，2，3 |4->2
         * -1，4，2，3 |4->2
         * 2，3，3，2，4 |2->3
         */
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            } // 不需要修改，跳过

            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) // 情况1和3
            {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            } // 情况2

        }
        return count <= 1;
    }
}
// @lc code=end
