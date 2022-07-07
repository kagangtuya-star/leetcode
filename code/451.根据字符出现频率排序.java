import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 * 
 * 此题使用桶排序
 * 首先构造一个哈希表，键是字符 s【i】，值是其出现的次数
 * 之后构建一个桶集合，每个字符元素都是一个桶，维护第i个桶中存放s中出现的出现次数为i的字符
 * 从后向前遍历此桶构建返回结果
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        //特殊值判断
        if(s.isEmpty() || s.length()==1){
            return s;
        }

        //构建哈希表，键是元素，值是频次
        Map<Character,Integer> bucket = new HashMap<>();
        //遍历填充，getordefault方法是当Map集合中有这个key时，就使用这个key对应的value值，如果没有就返回给定值，这里是0
        for(char c: s.toCharArray()){
            bucket.put(c, bucket.getOrDefault(c,0)+1);

        }
        
        //构建桶集合，个数为s长度+1，将频次为i的字符放到第i个桶里
        List<Character>[] b = new List[s.length()+1];
        for(char key:bucket.keySet()){
            //字符在哈希表里的值是多少就放到第几个桶，如果是空的初始化为数组再放
            int value = bucket.get(key);
            if(b[value]==null){
                b[value]=new ArrayList<Character>();
            }
            b[value].add(key);
        }

        //构建返回字符串，遍历桶
        StringBuilder res = new StringBuilder();

        for(int i =b.length-1;i>0;--i){
            //如果桶里有字符就遍历，出现几次往返回字符串添加几次
            if (b[i]!=null){
                for(char temp:b[i]){
                    for(int k=i;k>0;--k){
                        res.append(temp);
                    }
                }
            }
        }
        return res.toString();
    }
}
// @lc code=end

