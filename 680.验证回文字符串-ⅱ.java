/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 * 依然是双指针，并通过在新一轮比较中取出比过的字符来减少空间复杂度
 * /*题解：https://leetcode.cn/problems/valid-palindrome-ii/solution/cong-liang-ce-xiang-zhong-jian-zhao-dao-bu-deng-de/
 *  */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int p1 = 0;// 前指针
        int p2 = s.length() - 1;// 尾指针

        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                // 这里去掉比过的字符看是不是回文字符串
                return checkHuiWen(s, p1 + 1, p2) || checkHuiWen(s, p1, p2-1);
            }
            p1++;
            p2--;
        }
        return true;
    }

    // 结构与主函数相同，但作用是检测一个字符串中给定的区间是否是回文字符串
    public boolean checkHuiWen(String s, int front, int end) {
        while (front < end) {
            if (s.charAt(front) != s.charAt(end)) {
                return false;
            }
            front++;
            end--;
        }
        return true;
    }
}
// @lc code=end
