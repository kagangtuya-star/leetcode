import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        //结果集合
        List<Integer> result = new ArrayList<>();

        //求取并保存每个字母所在的最大下标位置(遍历 charat方法的作用是返回指定索引对应的字符)
        int[] max =new int[233];
        int len =s.length();
        for(int i=0;i<len;i++)
        {
            /*s.charAt(i)-'a'的值就是对应字母的索引值-1，如b
            的就是1*/
            max[s.charAt(i)-'a'] = i; 
        }
        //每个 片段开始与结束位置记录
        int start =0,end=0;
        //纪录每个正在划分的字符可能的最大位置，如果遍历的位置等于字母的最大位置（max数组）时，说明是该片段最终位置
        for (int j=0;j<len;j++)
        {
            end=Math.max(end, max[s.charAt(j)-'a']);
            if(j==end)
            {
                //保存结果并进行下一个片段的检索
                result.add(end-start+1);
                start=end+1;
            }
        }
        return result;
    }
}
// @lc code=end

