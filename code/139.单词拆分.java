import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 * 
 * 完全背包问题简单版本
 * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。如果求排列数就是外层for遍历背包，内层for循环遍历物品。
 * 这里任意，但因为是要求子串，最好是遍历背包放在外循环，将遍历物品放在内循环
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        // 字符串长度为i，dp[i]为true时，表示可以拆分为一个或多个在字典中出现的单词。
        dp[0] = true;// 初始化为真
        for (int i = 1; i <= s.length(); i++) {// 外层-题给字符串-背包
            for (int j = 0; j < i; j++) {// 内层-题给字典-物品-放回（重复用）-完全背包问题
                if (wordDict.contains(s.subSequence(j, i)) && dp[j]) {
                    dp[i] = true;
                    /*
                     * 确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，
                     * 那么dp[i]一定是true。（j < i ）
                     * 递推公式是 如果([j, i] 这个区间的子串出现在字典里 &&
                     * dp[j]是true) 那么 dp[i] = true
                     */
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end
