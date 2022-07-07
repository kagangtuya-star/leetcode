import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //长度与结果列表与结果数组
        int len=people.length;
        List<int[]> ans= new ArrayList<>();
        int[][] result =new int[len][2];
        /*两重排序，使用Lambda表达式简化写法：
         * 1.若数组第一位高位相同，第二位升序排列 如[7,0],[7,1]
         * 2.数组第一位高位不同（进行第一步后此时第二位是相同的），第一位降序排列 如[5,1],[6,1]
         * 思路参考：【巧用数组排序】leetcode 406 Queue Reconstruction by Height
https://b23.tv/BV1hK4y1m7jg
即先按照其中一维来排序，然后再按照另一维再次排序。
身高降序->序列号升序
         */
        Arrays.sort(people,((o1, o2) -> (o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0])));
        for (int[] p:people)
        {ans.add(p[1], p);}

        //列表转为结果数组
        for(int i=0;i<ans.size();i++)
        {
            result[i][0]=ans.get(i)[0];
            result[i][1]=ans.get(i)[1];
        }
        return result;
    }
}
// @lc code=end

