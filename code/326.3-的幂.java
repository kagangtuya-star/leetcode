/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3 的幂
 */

// @lc code=start
//基础算法
// class Solution {
//     public boolean isPowerOfThree(int n) {
//         if (n <= 0) {
//             return false;
//         }
//         while (n % 3 == 0) {
//             n /= 3;
//         }
//         return n == 1;
//     }
// }

//数学法
/*
 * 传参n的数据类型为 int，这引导我们首先分析出 int 范围内的最大 33 次幂是多少，约为 3^19 = 11622614673 
 * 判断 nn 是否为 11622614671162261467 的约数即可
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
// @lc code=end
