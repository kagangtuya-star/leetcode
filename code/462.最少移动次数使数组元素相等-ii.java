/*
 * @lc app=leetcode.cn id=462 lang=java
 *
 * [462] 最少移动次数使数组元素相等 II
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/solution/by-fuxuemingzhu-13z3/
 * 
 * 选择求取中位数 targe移动
 */

// @lc code=start
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int mid = nums[N / 2];//排序并求取中位数

        int res = 0;

        for (int n : nums) {
            res += Math.abs(n - mid);//求取到中位数的“距离”之和
        }

        return res;
    }
}
// @lc code=end
