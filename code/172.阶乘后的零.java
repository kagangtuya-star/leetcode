/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 * 
 * 归纳法
 * https://leetcode.cn/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
 * 1.找2x5
 * 2.含有 2 的因子每两个出现一次，含有 5 的因子每 5 个出现一次，所有 2 出现的个数远远多于 5，换言之找到一个 5，一定能找到一个 2 与之配对。所以我们只需要找有多少个 5
 * 3.5 的因子一定是每隔 5 个数出现一次计算,出现了多少个 5，我们只需要用 n/5就可以
 * 4.每隔 25 个数字，出现的是两个 5，所以除了每隔 5 个数算作一个 5，每隔 25 个数，还需要多算一个 5。也就是我们需要再加上 n / 25 个 5
 * 5.以此类推：最终 5 的个数就是 n / 5 + n / 25 + n / 125 ...
 * 6.写程序的话，如果直接按照上边的式子计算，分母可能会造成溢出。所以算 n / 25 的时候，我们先把 n 更新，n = n / 5，然后再计算 n / 5 即可
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;// 拿n=50来说，就是找50/5+10/5+2/5=10+2+0
            n = n / 5;
        }
        return count;
    }
}
/*
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 49.58 % of java submissions (38.6 MB)
 */
// @lc code=end
