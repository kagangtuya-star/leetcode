/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 * 
 * 双指针模拟人的计算过程
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder(""); // 返回的结果
        int i = num1.length() - 1;// 指向数字末位的指针
        int j = num2.length() - 1;
        int carry = 0; // 进位
        while (i >= 0 || j >= 0) {

            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;// 数字转换，理论上都是大于0的

            int tmp = n1 + n2 + carry;// 模拟人的计算过程
            carry = tmp / 10;// 得出进位多少
            res.append(tmp % 10);// 取去掉进位后的结果加入结果字符串

            i--;// 前移
            j--;
        }

        if (carry == 1)// 进位为1的时候说明头部应该加上进位
        {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
/*
 * Your runtime beats 32.77 % of java submissions
 * Your memory usage beats 76.79 % of java submissions (41.3 MB)
 */
// @lc code=end
