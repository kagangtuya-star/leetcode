/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
         * 首先强力推荐这个解法思路，极其详细而容易理解
         * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/solution/yi-
         * zhang-tu-gao-su-ni-on-de-shuang-zhi-zhen-jie-fa/
         * 此题使用双指针（这里是数组下标索引），原理是通过比较后不断缩减搜索空间，让时间效率降到o(n)
         */
        int i = 0;
        int j = numbers.length - 1;
        // 约束条件是：i、j都是合法的数组下标,与题目要求的i<j
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            }
            /*
             * "此时 A[0] + A[7] 小于 target。
             * 这时候，我们应该去找和更大的两个数。由于 A[7] 已经是最大的数了，
             * 其他的数跟 A[0] 相加，和只会更小。也就是说 A[0] + A[6] 、A[0] +
             * A[5]、……、A[0] + A[1] 也都小于 target，这些都是不合要求的解，可以
             * 一次排除。" 这里相当于减少了一行i的搜索空间
             */
            else if (sum > target) {
                j--;
            } // 同理，不过是j的
            else {
                return new int[] { i + 1, j + 1 };
            } // 反馈回结果
        }
        return new int[] { -1, -1 }; // 错误答案
    }
}
// @lc code=end
/*
 * Accepted
    21/21 cases passed (1 ms)
    Your runtime beats 98.64 % of java submissions
    Your memory usage beats 7.53 % of java submissions (44.5 MB)
 */