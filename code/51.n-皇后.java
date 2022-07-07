import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 * 
 * 回溯算法；这仍然是一个遍历树+回溯的应用问题
 * 尝试按照题解将代码函数化更容易读懂
 * https://leetcode.cn/problems/n-queens/solution/dai-ma-sui-xiang-lu-51-n-queenshui-su-fa-2k32/
 * 
 */

// @lc code=start
class Solution {
    List<List<String>> res  = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for(char[] c:chess){
            Arrays.fill(c, '.');//初始化，全部空放为.
        }
        backtrack(n, 0, chess);//开始执行回溯算法
        return res;

    }

    //回溯模板
    /*void backtracking(参数) {
        if (终止条件) {
            存放结果;
            return;
        }
        for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
            处理节点;
            backtracking(路径，选择列表); // 递归
            回溯，撤销处理结果
        }
    }*/
    //n是棋盘的大小，row是遍历到第几层了
    public void backtrack(int n,int row,char[][] chess){
        if(row==n){//递归到棋盘最底层（叶子节点）时中止
            res.add(array2list(chess));
            return;
        }

        for(int col=0;col<n;++col){//一个个格子进行树的构建与搜索
            if(isvaild(row, col, n, chess)){ //如果这个格子符合条件，就放置皇后
                chess[row][col]='Q';
                backtrack(n, row+1, chess);//递归检测，广度搜索 树的应用
                chess[row][col]='.';//回溯，取下皇后棋
            }
        }
    }

    //转换器：数组->列表
    public List array2list(char[][] chess){
        List<String> list = new ArrayList<>();
        for(char[] c:chess){
            list.add(String.copyValueOf(c)); //copyvalueof方法：此方法返回一个新的字符串数组并将字符复制到其中
        }
        return list;
    }

    //检查棋子的排列是否符合规则，即剪枝,此处无需检查同行，因为每一次for循环检测用的是同一行的一个元素，不存在重复现象
    //row表示遍历到第几层了，col是列(纵坐标)，n为棋盘大小
    public boolean isvaild(int row,int col,int n,char[][] chess){
        //检查列的合法性
        for(int i=0;i<row;++i){
            if(chess[i][col]=='Q'){
                return false;
            }
        }
        //检测45度对角线
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
        //检测135度对角线
        for(int i=row-1,j=col+1;i>=0&&j<=n-1;i--,j++){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

}
// @lc code=end

