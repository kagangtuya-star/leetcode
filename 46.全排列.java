import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 * 
 * 回溯法与深度优先搜索，参考题解如下
 * 
 * https://leetcode.cn/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len =nums.length;
        List<List<Integer>> res=new ArrayList<>();///数组长度与返回列表

        if(len==0){
            return res;//长度为的特例
        }

        boolean[] used = new boolean[len]; //布尔数组 used，初始化的时候都为 false 表示这些数还没有被选择，当我们选定一个数的时候，就将这个数组的相应位置设置为 true
        List<Integer> path =new ArrayList<>();//path变量，存放已经操作过的数，便于回溯，类似栈

        //dfs搜索,从深度0开始
        dfs(nums, len, 0, path, used, res);
        return res;
    }
    //dfs算法，几个变量为题设数组、题设数组长度、回溯深度、回溯path指示变量、布尔数组uessd，返回结果用的列表res
    private void dfs(int[] nums,int len,int depth,List<Integer> path,boolean[] used,List<List<Integer>> res){
        if(depth==len){
            res.add(path);//无需copy，每一层传递下来的path变量是新建的
            return;
        }
        //深度遍历
        for(int i=0;i<len;i++){
            //若未选择过，则进行选择，每一次尝试都创建新变量(path,uesd这两个)表示当前状态
            if(!used[i]){
                //新的path
                List<Integer> newpath = new ArrayList<>(path);
                newpath.add(nums[i]);

                //新的used
                boolean[] newused = new boolean[len];
                System.arraycopy(used, 0, newused, 0, len);//数组copy函数
                newused[i]=true;

                dfs(nums, len, depth+1, newpath, newused, res);
                //深度+1，继续向下搜索
            }
        }
    }
}
// @lc code=end

