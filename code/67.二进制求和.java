/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 * 
 * 使用字符串的性质来解
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;// 进位数
        // 从后向前来加 直接拼接字符串，会得到一个反向字符，需要最后再进行翻转
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;// 进位
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0; // 有可能两个数字长度不一致，如果i<0（j<0）的话则将其当做0来处理，否则获取其值，也就是 b.charAt(j或i) - '0'
            ans.append(sum % 2);// 计算结果放进去
            ca = sum / 2; // 进位计算 ，满2进1
        }

        ans.append(ca == 1 ? ca : ""); // 有进位，则在前方进行字符串拼接添加进位
        return ans.reverse().toString();
    }
}
// @lc code=end
