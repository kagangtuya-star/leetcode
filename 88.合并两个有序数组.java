/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 * 参考思路：https://leetcode.cn/problems/merge-sorted-array/solution/ni-xiang-shuang-zhi-zhen-he-bing-liang-g-ucgj/
 * 本题关键：从后向前遍历——避免破坏数组的有序、双指针（第三个指针用于记录位置）、原地修改（将空间大的老数组作为新数组的空间）——降低空间复杂度
 * 小技巧：a++ 和 ++a 都是将 a 加 1，但是 a++ 返回值为 a，而++a 返回值
 *        为 a+1。如果只是希望增加 a 的值，而不需要返回值，则推荐使用 ++a，
 *        其运行速度会略快一些。
 * 
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1; // 双指针
        int tail = m + n - 1;// 指向新数组末尾的指针
        int temp;
        while (p1 >= 0 || p2 >= 0) // 检验条件：指针指向的位置在数组中
        {
            if (p1 == -1) {
                temp = nums2[p2--];
            } else if (p2 == -1) {
                temp = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                temp = nums1[p1--];
            } else {
                temp = nums2[p2--];
            }
            /*
             * 四种情况：
             * 1、2，对应数组到最左侧溢出的填补
             * 3、4，按照指针指向的数组值比大小的结果进行原地修改和指针移位
             */
            nums1[tail--] = temp;// 向新数组填充
        }

    }
}
// @lc code=end
