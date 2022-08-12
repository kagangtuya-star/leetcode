/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
//倍数法 或者叫埃式筛
class Solution {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            // 如果不是素数就不需要计数了，直接看下一个
            if (notPrimes[i]) {
                continue;
            }
            count++;

            // 如果不是素数，直接让他的2倍，3倍……j倍（不能越界 j<n ），都标记为非素数
            for (int j = i; j < n; j += i)
                notPrimes[j] = true;
        }
        return count;
    }
}
/*
 * Your runtime beats 50.53 % of java submissions
 * Your memory usage beats 80.68 % of java submissions (45.6 MB)
 */
// @lc code=end
