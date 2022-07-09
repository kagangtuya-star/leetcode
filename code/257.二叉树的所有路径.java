import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
  @lc app=leetcode.cn id=257 lang=java
 
  [257] 二叉树的所有路径
  
  回溯+递归
 */

// @lc code=start
//   public class TreeNode {
//       int val;
//       TreeNode left;
//       TreeNode right;
//       TreeNode() {}
//       TreeNode(int val) { this.val = val; }
//       TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//       }
//   }

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // 结果集与路径集
        List<String> res = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();

        if (root == null) {
            return res;// 空值直接返回
        }

        traver(root, paths, res);
        return res;
    }

    // 递归函数：根节点，记录路径的paths，结果集res
    public void traver(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val); // 加入根节点
        // 终止条件：当遍历到的节点不为空，其左右孩子都为空的时候，就找到叶子节点
        if (root.left == null && root.right == null) {
            // 构建输出
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < paths.size() - 1; i++) { // 将paths里记录的路径转换为字符串
                s.append(paths.get(i)).append("->");// 变成返回数组的格式
            }
            s.append(paths.get(paths.size() - 1));// 记录最后一个节点（叶子结点
            res.add(s.toString());// 构建结果集
            return;
        }
        // 若有左孩子则继续遍历
        if (root.left != null) {
            traver(root.left, paths, res);
            paths.remove(paths.size() - 1);// 遍历完成后回溯
        }
        // 右孩子同理
        if (root.right != null) {
            traver(root.right, paths, res);
            paths.remove(paths.size() - 1);// 遍历完成后回溯
        }

    }
}
// @lc code=end
