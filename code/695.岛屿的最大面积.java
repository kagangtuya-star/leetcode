/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //定义一个表示岛屿的面积
        int max = 0;
        //这两个for循环是来遍历整张二维格上的所有陆地的。
        //i 表示行，j表示列
        for(int i = 0;i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                //陆地的格
                if(grid[i][j]==1){
                    //取出最大的面积
                    max = Math.max(max,dfs(grid,i,j));
                }  
            }
        }
        //返回最大的陆地面积
        return max;
    }
    public int  dfs(int[][] grid,int i,int j){
        //当超出岛屿边界（上下左右）的时候，就直接退出，特别要加上当遍历到海洋的时候也要退出，
        if(i<0||j<0 || i>=grid.length || j>= grid[0].length|| grid[i][j]==0) return 0;
       //定义一个变量表示岛屿的面积，就是包含几个陆地
        int sum = 1;
        //将陆地改为海洋，防止重复陆地重复遍历。
        grid[i][j] =0;
        //遍历上方元素，每遍历一次陆地就加一
        sum += dfs(grid,i+1,j);
        //遍历下方元素
        sum +=dfs(grid,i-1,j);
        //遍历右边元素
        sum +=dfs(grid,i,j+1);
        //遍历左边元素
        sum += dfs(grid,i,j-1);
        return sum;
    }
}
// @lc code=end

