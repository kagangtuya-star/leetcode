/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
// public class Solution {
//     public int maxSubArray(int[] nums) {
//         int len = nums.length;
//         if (len == 0) {
//             return 0;
//         } // 特值判断

//         int[] dp = new int[len];// dp[i]是为以i结尾子串的最大值
//         dp[0] = nums[0];// 初始化：第0个自然为题设数组的第一个值

//         for (int i = 1; i < len; i++) {
//             /*
//              * 分解为如下比较的子问题
//              * 第一个子组合是以第一个数字结尾的连续序列，也就是 [-2]，最大值-2
//              * 第二个子组合是以第二个数字结尾的连续序列，也就是 [-2,1], [1]，最大值1
//              * 第三个子组合是以第三个数字结尾的连续序列
//              * .....
//              */
//             // 拆分子数组：继承子组合二得到的序列与单独第三个数字的序列
//             if (dp[i - 1] >= 0) {// 第二个序列的最大值大于0，那么最大值1就比最大值2要大，反之最大值2较大
//                 dp[i] = dp[i - 1] + nums[i];// 有没有正增益
//             } else {
//                 dp[i] = nums[i];// 没有正增益
//             }
//         }

//         int res = dp[0];// 可能初值会最大
//         for (int i = 1; i < len; i++) {
//             res = Math.max(res, dp[i]);
//         } // 进行一轮比较
//         return res;
//     }
// }
// /*
//  * Your runtime beats 37.09 % of java submissions
//  * Your memory usage beats 16.57 % of java submissions (51 MB)
//  */

//空间压缩
//一个变量subMax保存前面子组合的最大值，另外一个max保存全局最大值
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = nums[0]; // 全局最大值
        int subMax = nums[0]; // 前一个子组合的最大值,状态压缩
        for (int i = 1; i < nums.length; i++) {
            if (subMax > 0) {
                subMax = subMax + nums[i];
            } else {
                subMax = nums[i];
            }
            // 计算全局最大值
            max = Math.max(max, subMax);
        }

        return max;
    }
}
/*
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 37.75 % of java submissions (50.8 MB)
 */
// @lc code=end
