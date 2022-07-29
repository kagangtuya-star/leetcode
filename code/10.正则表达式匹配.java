/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 * 动态规划
 * 从右向左扫描
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        boolean[][] dp = new boolean[cs.length + 1][cp.length + 1];// dp[i][j]:s的前i个字符是否匹配p的前j个字符

        // 初始化
        dp[0][0] = true; // s为空，p为空，能匹配

        // 预先检查一边正则式，如果出现了*（匹配多个），则对于s的前i个字符匹配p的前0个字符来说，它们得结果相同
        for (int j = 1; j <= cp.length; j++) {
            if (cp[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 开遍历，正向的
        for (int i = 1; i <= cs.length; i++) {
            for (int j = 1; j <= cp.length; j++) {
                // 最右端的字符是匹配的，那么，大问题的答案 = 剩余子串是否匹配
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                    // 右端不匹配，还不能判死刑——可能是 p[j-1]为星号造成的不匹配，星号不是真实字符，它不匹配不算数。
                } else if (cp[j - 1] == '*') { // 而当模式串末位是*
                    // 模式串*的前一个字符能够跟文本串的末位匹配上，则有几种情况，*匹配0次到匹配多次
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2] // *匹配0次的情况
                                || dp[i - 1][j]; // *匹配1次或多次的情况

                    } else { // 模式串*的前一个字符不能够跟文本串的末位匹配
                        dp[i][j] = dp[i][j - 2]; // *只能匹配0次
                    }
                }
            }
        }
        return dp[cs.length][cp.length];
    }
}
// @lc code=end
