/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 * 
 * 经典的通用进制转换算法——辗转相除，把7换掉就成其他的
 */

// @lc code=start
class Solution {
    public String convertToBase7(int n) {
        boolean flag = n < 0; // 正负判断
        // 绝对值转换
        if (flag) {
            n = -n;
        }
        StringBuilder sb = new StringBuilder(); // 收集每一位数字
        // 辗转相除，直到除成0
        do {
            sb.append(n % 7);
            n /= 7;
        } while (n != 0);

        sb.reverse();// 结束数字收集
        return flag ? "-" + sb.toString() : sb.toString();// 根据flag取正负
    }
}
// @lc code=end
