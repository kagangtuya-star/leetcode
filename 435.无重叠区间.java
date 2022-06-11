import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //0个数组自然为零
        if (intervals.length==0)
        {return 0;}
        //用sort方法自定义方法对数组进行以首位为基准的降位排序
        Arrays.sort(intervals,new Comparator<int[]>() {
            public int compare(int[] intervals1,int[] intervals2)
            {return intervals1[1]-intervals2[1];}
        });
        int leng=intervals.length;
        int right=intervals[0][1];
        int temp=1; //次数计数器
        //每次选择结尾最小且和前一个选择的区间不重叠的区间
        for(int i =1;i<leng;++i){
            if(intervals[i][0]>=right) //当前遍历到的区间与上一个区间不重合,则选择此区间并更新right
            {
                ++temp;
                right=intervals[i][1];
            }
        }
        return leng-temp;
    }
}
// @lc code=end

