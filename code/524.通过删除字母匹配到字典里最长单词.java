import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 * 由题意，要找的字符串是dic中为s的子序列，且长度最长（优先级高）与字母序列最小
 * 对dic进行排序，首先按字符串长度排倒序，长度相同的就按字母序排升序
 * 随后使用双指针对dic进行顺序查找，直到其被匹配完
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
		//排序
        Collections.sort(dictionary,(a,b)->{
            if(a.length()!=b.length())
            {return b.length()-a.length();}
            return a.compareTo(b);
        });

        int n=s.length();
        //反复重复匹配操作
        for(String ss:dictionary){
            int m=ss.length();
            int i=0,j=0;//双指针,使用它们分别指向s或dic中的哪个字符，之后是对dic进行遍历
            while (i<n&&j<m)
            //当 s[i] != dictionary[x][j]，使 i 指针右移，
            //直到找到 s 中第一位与 dictionary[x][j] 对得上的位置，
            //然后当 i 和 j 同时右移，匹配下一个字符；
            {
                if(s.charAt(i)==ss.charAt(j))
                {j++;}
                i++;
            }
            if(j==m)            
            {return ss;}
        }
        return "";
    }
}
// @lc code=end

