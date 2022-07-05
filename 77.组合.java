import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 * 
 * 此题考察回溯与剪枝，核心是遍历n与k的构成的树，并去除少于k个
 * 的结果（剪枝）
 * https://leetcode.cn/problems/combinations/solution/hua-jie-suan-fa-77-zu-he-by-guanpengchn/
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        returnres(n, k, 1, new ArrayList<>());
        return ans;
    }

    // 输入参数：题设数n，k，从第几层开始向下搜索（开始位置），回溯列表list
    public void returnres(int n, int k, int start, List<Integer> list) {
        // 特例判断，返回为空
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // 构造，从第一层（本题start设定为1）开始向下递归调用函数，将当前位置数加入list中并进入下一层
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            returnres(n, k - 1, i + 1, list);// 重复调用，继续深一层构建树
            list.remove(list.size() - 1);
            /*
             * 其中循环结束条件默认为最大值到 n，这里可以优化进行剪枝，
             * 比如 n=4，k=3 时，如果列表从 start=3 也就是 [3] 开始，
             * 那么该组合一定不存在，因为至少要 k=3 个数据，所以剪枝临界
             * 点为 n-balance+1
             */
        }
    }
}
// @lc code=end
