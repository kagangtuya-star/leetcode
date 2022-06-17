import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 * 这道题要求我们返回字符串 s中包含字符串 t 的全部字符
 * 的最小窗口，我们利用滑动窗口的思想解决这个问题。因此
 * 我们需要两个哈希表，hs哈希表维护的是s字符串中滑动窗口中
 * 各个字符出现多少次，ht哈希表维护的是t字符串各个字符出现
 * 多少次。如果hs哈希表中包含ht哈希表中的所有字符，并且对应的
 * 个数都不小于ht哈希表中各个字符的个数，那么说明当前的窗口是
 * 可行的，可行中的长度最短的滑动窗口就是答案。
 * 参考题解：https://www.bilibili.com/video/BV15S4y1U767
 * 
 * 滑动窗口由两个指针构成，通过以各种设定条件调整双指针的位置来框选一维数组等类似数据结构中的局部。
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        // 两个哈希表，hs分别用于存储给定字符串t中字母的出现频次，ht用于存放滑动窗口中各个字符的出现频次
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        HashMap<Character, Integer> ht = new HashMap<Character, Integer>();
        // 记录字符串t的字母频次 getOrDefault方法：获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 结果字符
        String ans = "";
        // 初始化最大长度为无穷大，窗口宽度为0

        int len = 0x3f3f3f3f, cnt = 0;
        // 遍历给定字符串s,i为窗口右侧指针，j为窗口左侧指针,不断扩展窗口右侧
        for (int i = 0, j = 0; i < s.length(); i++) {
            // 与扫描t的原理相同
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
            // 如果新加入的字符是t中所没有的或者所需的（hs[s[i]] <= ht[s[i]]），则加入其中，并让窗口长度记录变量cnt++
            if (ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) {
                cnt++;
            }
            /*
             * 这是收缩滑动窗口，当hs[s[j]] > ht[s[j]时，说明hs哈希表中s[j]的数量多于
             * ht哈希表中s[j]的数量，此时我们就需要向右收缩滑动窗口
             */
            while (j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j++;
            }
            // 当cnt == t.size时，说明此时滑动窗口包含符串 t 的全部字符,此时应该重复上述过程找出最小的答案
            if (cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }
}
// @lc code=end
