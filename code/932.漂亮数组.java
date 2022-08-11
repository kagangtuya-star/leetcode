/*
 * @lc app=leetcode.cn id=932 lang=java
 *
 * [932] 漂亮数组
 * 
 * 分治思想+一些数学知识
 */

// @lc code=start
class Solution {
    Map<Integer, int[]> memo;// 结果

    public int[] beautifulArray(int N) {
        memo = new HashMap<>(); // memo是个哈希表

        memo.put(1, new int[] { 1 }); // 放个1
        return f(N);
    }

    private int[] f(int N) {
        if (!memo.containsKey(N)) { // memo里没有包含为N的值

            int index = 0;
            int[] res = new int[N];

            for (int x : f((N + 1) / 2)) { // 奇数组递归
                res[index++] = 2 * x - 1; // 一个数组是漂亮数组，那么其线性变换之后的数组也是漂亮数组
            }
            for (int x : f(N / 2)) { // 偶数组递归
                res[index++] = 2 * x;
            }
            memo.put(N, res);
        }
        return memo.get(N);
    }
}

// @lc code=end
/*
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 13.73 % of java submissions (41.4 MB)
 */
