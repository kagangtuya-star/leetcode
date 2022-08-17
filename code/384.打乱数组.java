/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {
    int[] nums;
    int n;
    Random random = new Random();// 发生随机数

    public Solution(int[] _nums) { // 初始化类，给出数组与数组长度
        nums = _nums;
        n = nums.length;
    }

    // 重设数组到它的初始状态
    public int[] reset() {
        return nums;
    }

    // 随机返回数组打乱后的结果
    public int[] shuffle() {
        int[] ans = nums.clone();// 克隆一个数组
        for (int i = 0; i < n; i++) {// 全数随机交换
            swap(ans, i, i + random.nextInt(n - i));
        }
        return ans;
    }

    // 临时的交换函数，在数组arr中，把i与j交换位置
    void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end
