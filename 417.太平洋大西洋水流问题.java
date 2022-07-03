import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 * 
 * dfs搜索算法
 * 流向汇点（海域）是按照高度从高到低（非严格）的规
 * 则，那么反过来从海域到格子则是按照从低到高（非严格）
 * 规则进行，同时本身处于边缘的格子与海域联通。
 * 因此我们可以使用两遍 DFS/BFS 进行求解：
 * 分别从与当前海域直接相连的边缘格子出发，
 * 统计能够流向当前海域的格子集合，两片海域求得
 * 的集合交集即是答案。
 * 
 * 解题方法：构造返回矩阵res1与res2，res[i][j]表示对应
 * 格子（i，j）能流向海域，起始将所有与海域相连的格子放入队列
 * 然后跑一次dfs，则所有进入海域的格子都能进入队列
 */

// @lc code=start
class Solution {
    // 使用全局变量
    int n, m;// 横纵坐标
    int[][] a;// 中间变量

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        a = heights;
        m = a.length;
        n = a[0].length;
        // 返回的结果数组
        boolean[][] res1 = new boolean[m][n];
        boolean[][] res2 = new boolean[m][n];

        // 进行dfs搜索
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果在海边且未dfs搜索过则进行dfs
                if (i == 0 || j == 0) {
                    if (!res1[i][j]) {
                        dfs(i, j, res1);
                    }
                }
                // 一层一层地对未搜索过的格子进行dfs搜索
                if (i == m - 1 || j == n - 1) {
                    if (!res2[i][j]) {
                        dfs(i, j, res2);
                    }
                }
            }
        }
        // 存放结果的队列,将两个res数组中的结果合起来
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果两个返回数组都表明某个格子可以流向所有海域则整合进去
                if (res1[i][j] && res2[i][j]) {
                    // 使用一个临时的列表以添加两个坐标
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    void dfs(int x, int y, boolean[][] res) {
        res[x][y] = true;
        for (int[] di : dirs) {
            int nx = x + di[0], ny = y + di[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;
            if (res[nx][ny] || a[nx][ny] < a[x][y])
                continue;
            dfs(nx, ny, res);
        }
    }

}

// @lc code=end
