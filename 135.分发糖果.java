/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int candy[] = new int[ratings.length];
        // 第一次遍历：初始化为1
        for (int i = 0; i < ratings.length; i++) {
            candy[i] = 1;
        }
        /* 第二次遍历：从左往右遍历一遍，如果右边孩子的评分比左边的高，则右边孩子的糖果数变为左边孩子的糖果数加 1 */
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        /*
         * 第三次遍历 ：右往左遍历一遍，如果左边孩子的评分比右边的高，且左边孩子当前的糖果数不大于右边孩子的糖果数，则左边孩子的糖果数更新为右边孩子的糖果数加 1
         */
        for (int i = ratings.length - 2; i > -1; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        // 最后一次遍历：求和返回结果
        int count = 0;
        for (int i = 0; i < candy.length; i++) {
            count += candy[i];
        }
        return count;
    }
}
// @lc code=end
