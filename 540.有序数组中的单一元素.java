/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素+
 * 
 * 只有一个数只出现一次，那么，如果我们把这个数补齐到两个，
 * 可以发现，每一对 [偶数下标, 奇数下标] 的数肯定是相等的，
 * 因此，我们可以利用这条特性来进行二分查找
 * 如果 mid 所在的 [偶数下标, 奇数下标] 的值相等，
 * 说明前面半段没有缺失的数，那么，缺失的数肯定在后半段，
 * 反之，则在前半段
 * 
 * 如果 mid 本身是偶数，那么 mid + 1 就是奇数；
 *  如果 mid 本身是奇数，那么 mid - 1 就是偶数
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // 二分查找
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            //前半段
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 1; //偶变奇
                } else {
                    right = mid;
                }
            } else {
                //后半段
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;//奇数变偶数
                } else {
                    right = mid;
                }
            }
        }
        return nums[right];
    }
}
// @lc code=end
