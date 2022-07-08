/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域+
 * 
 * dfs遍历
 * 从边界出发吧，先把边界上和 O 连通点找到,
 * 把这些变成 B（或者其他，都可以）,然后遍历整个被围区间把 O 变成 X, 
 * 把 B 变成 O
 * https://leetcode.cn/problems/surrounded-regions/solution/dfs-bfs-bing-cha-ji-by-powcai/
 */

// @lc code=start
class Solution {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // 坐标偏移量，用于调整扫描方向

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board.length == 0) {
            return; // 排除空值
        }

        int row = board.length;// 列
        int col = board[0].length;// 行

        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O')
                dfs(0, j, board, row, col);
            if (board[row - 1][j] == 'O')
                dfs(row - 1, j, board, row, col);
        }

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board, row, col);
            if (board[i][col - 1] == 'O')
                dfs(i, col - 1, board, row, col);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    // dfs搜索，把边界上和 O 连通点找到，变成B
    private void dfs(int i, int j, char[][] board, int row, int col) {
        board[i][j] = 'B';
        for (int[] dir : dirs) {
            int di = dir[0] + i;
            int dj = dir[1] + j;
            if (di < 0 || di >= row || dj < 0 || dj >= col || board[di][dj] != 'O') {
                continue;
            }
            dfs(di, dj, board, row, col);
        }
    }
}
// @lc code=end
