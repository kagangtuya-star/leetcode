import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 * 
 * 练习一下回溯三部曲方法
 * https://leetcode.cn/problems/combination-sum-ii/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-ig29/
 * 
 */

// @lc code=start
class Solution {
    // 用到的结果集列表、队列与和
    List<List<Integer>> lists = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序
        Arrays.sort(candidates);
        // 标志数组，同层是否排序
        boolean[] flag = new boolean[candidates.length];
        backtracking(candidates, target, 0, flag);
        return lists;
    }

    /*
     * 回溯三部曲之
     * 递归函数参数
     * 递归终止条件
     * 单层搜索的逻辑
     */
    public void backtracking(int[] arr, int target, int index, boolean[] flag) {
        if (sum == target) {// 符合题意，加入结果集
            lists.add(new ArrayList(deque));
            return;
        }
        for (int i = index; i < arr.length && arr[i] + sum <= target; i++) {
            // 出现重复节点，同层第一个节点被访问过，跳！
            if (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            sum += arr[i];
            deque.push(arr[i]);
            // 每个节点仅能选择一次
            backtracking(arr, target, i + 1, flag);
            int temp = deque.pop();
            flag[i] = false;
            sum -= temp; // 回溯

        }

    }
}
// @lc code=end
