/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 * 
 * 二分法查找
 * 猜的数平方以后大了就往小了猜；
 * 猜的数平方以后恰恰好等于输入的数就找到了；
 * 猜的数平方以后小了，可能猜的数就是，也可能不是。
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {

        // 0和1是特殊值
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        // 在【l，r】之间二分查找,根据大小更换二分查找的区间
        int l = 1, r = x / 2;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}
// @lc code=end
