/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 * 
 * 第k个元素法
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/solution/by-sdwwld-o2k0/
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        // 如果是奇数，只需要求中间的那个就可以了
        if (total % 2 == 1)
            return getKth(nums1, 0, nums2, 0, (total + 1) >> 1);
        // 如果是偶数，求中间的两个元素，最后计算平均值
        return (getKth(nums1, 0, nums2, 0, total >> 1)
                + getKth(nums1, 0, nums2, 0, total / 2 + 1)) * 0.5;
    }

    // 求第k个元素,start1和2是变化后的数组首位
    private int getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int length1 = nums1.length - start1;
        int length2 = nums2.length - start2;
        // 始终保证第一个数组小于等于第二个数组
        if (length1 > length2)
            return getKth(nums2, start2, nums1, start1, k);
        // 如果第一个数组为空，直接取第二个数组的第k个元素
        if (length1 == 0)
            return nums2[start2 + k - 1];
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);
        int newStart1 = start1 + Math.min(length1, k / 2) - 1;
        int newStart2 = start2 + Math.min(length2, k / 2) - 1;
        if (nums1[newStart1] > nums2[newStart2]) {
            // 砍掉数组2的前部分
            return getKth(nums1, start1, nums2, newStart2 + 1, k - (newStart2 - start2 + 1));
        } else {
            // 砍掉数组1的前部分
            return getKth(nums1, newStart1 + 1, nums2, start2, k - (newStart1 - start1 + 1));
        }
    }
}
// @lc code=end
