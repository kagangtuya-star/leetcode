/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 * 
 * 双指针解法：
 * a，b的范围应该在0~根号c之间，因此使用双指针扫描这个区间
 * 有三种情况，令a在区间最左边，b在区间最右边
 * 当a与b的平方和等于c的平方时，得出正确的结果
 * 当a与b的平方和大于c的平方时，说明当前值太小了，a右移a++
 * 当a与b的平方和小于c的平方时，说明当前值太大了，b左移b--
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        /*int a = 0;
        int b = (int) Math.sqrt(c);// 开方
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
        玄学啊！试试枚举算法*/
        int max = (int)Math.sqrt(c);
        for (int a = 0; a <= max; a++) {
            int b = (int)Math.sqrt(c - a * a);
            if (a * a + b * b == c) return true;
        }
        return false;
    }
}
// @lc code=end
