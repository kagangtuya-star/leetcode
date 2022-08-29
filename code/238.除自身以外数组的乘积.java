/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积——将ans[i]拆解为num[1,i]的前缀乘（s1）与num[i,n]的后缀乘（s2），那么ans[i−1]=s1[i−1]×s2[i+1]
 * 运用「前缀和」思想，使用数组 s1 和 s2 分别计算范围 [1, x] 的前缀乘 和范围
 *  [x, n]的后缀乘法（前缀和数组下标默认从 11 开始），即 s1[i] 代表范围 
 * [1,i]的前缀乘，s2[i]代表范围 [i, n]的后缀乘值
 */

// // @lc code=start
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[n];//结果数组与s1 s2
//         int[] s1 = new int[n + 10], s2 = new int[n + 10];
//         s1[0] = s2[n + 1] = 1;//赋予初始值，都是1

//         for (int i = 1; i <= n; i++) {
//             s1[i] = s1[i - 1] * nums[i - 1];//计算前缀乘，连乘
//         }

//         for (int i = n; i >= 1; i--) {
//             s2[i] = s2[i + 1] * nums[i - 1];//后缀乘
//         }

//         for (int i = 1; i <= n; i++) {//挨个算结果
//             ans[i - 1] = s1[i - 1] * s2[i + 1];
//         }

//         return ans;
//     }
// }
//空间优化，直接用ans数组替代s1与s2
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 1, j = 1; i <= n; i++) {
            ans[i - 1] = j;
            j *= nums[i - 1];
        }
        for (int i = n, j = 1; i >= 1; i--) {
            ans[i - 1] *= j;
            j *= nums[i - 1];
        }
        return ans;
    }
}
// @lc code=end
