/*
 * @lc app=leetcode.cn id=528 lang=java
 *
 * [528] 按权重随机选择
 * 
 * 二分法什么的，不太会
 * https://leetcode.cn/problems/random-pick-with-weight/solution/gong-shui-san-xie-yi-ti-shuang-jie-qian-8bx50/
 * 还是看题解吧
 * 
 * 使用「前缀和」数组来作为权重分布序列，权重序列的基本单位为 11
 */

// @lc code=start
class Solution {
    int[] sum;

    public Solution(int[] w) {
        int n = w.length;
        sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int n = sum.length;
        int t = (int) (Math.random() * sum[n - 1]) + 1;
        int l = 1, r = n - 1;

        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end
