/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 * 
 * 回溯剪枝、dfs
 */

// @lc code=start
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        // 排除空值
        if (len == 0) {
            return res;
        }
        // 先排序后去重，减少计算
        Arrays.sort(nums);

        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            /*
             * 因为之前已经拍好序了，所以当前元素nums[i] 如果和前一个元素相同
             * 即nums[i] == nums[i-1]就说明该分支有可能是重复的
             * 这个相等条件有两种可能：一种两个元素虽然重复，但是第二个元素是前一个元素的下一层，
             * 这时是没有问题的；另一种是两个元素重复，且重的是同层路径。那就说明是重复分支。
             */
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, used, path, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }
}
// @lc code=end
