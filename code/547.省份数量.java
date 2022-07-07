/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 * 
 * dfs遍历算法
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // 被访问过的城市存放的数组
        int leng = isConnected.length;
        boolean[] visited = new boolean[leng];
        // 省份数量
        int res = 0;
        // 遍历
        for (int i = 0; i < leng; i++) {
            // 当前未访问则是个新省份，res++，与之项链的标记为访问过
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                res++;
            }
        }
        return res;

    }

    // dfs遍历算法:核心为如果第i个和第j个城市链接，则说明是一个省份的，标记为访问过，同时从查找与第j个相连的城市
    public void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }

}
// @lc code=end
