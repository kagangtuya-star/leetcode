/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 * 
 * 实际上是转换为26进制
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            // 本题并非从0开始，故每次-1，其余套用上次的进制转换方式即可
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
// @lc code=end
