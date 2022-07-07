/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 * 二分法
 * 题解与模板：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solution/tu-jie-er-fen-zui-qing-xi-yi-dong-de-jia-ddvc/
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 特殊情况
        if (nums.length == 0)
            return new int[] { -1, -1 };

        int l = 0, r = nums.length - 1;
        // 第一次查找，找出左边界
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } // 往左半区域
            else {
                l = mid + 1;// 往右半区域
            }
        }
        if (nums[r] != target) {
            return new int[] { -1, -1 };
        } // 找不到

        // 保存数据，并重置条件
        int L = r;
        l = 0;
        r = nums.length - 1;

        // 第二次找，找出右边界
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } // 往左
            else {
                r = mid - 1;
            } // 往右
        }

        return new int[] { L, r };
    }
}
// @lc code=end
