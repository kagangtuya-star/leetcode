import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 * 使用最小堆排序
 * 借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
 * 维护一个元素数目为 k的最小堆
 * 每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
 * 如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中、
 * 最终，堆中的 k个元素即为前 k个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 字典哈希表，统计出现频次
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) { // containskey方法检查哈希表内是否存在参数，有返回true
                map.put(num, map.get(num) + 1); // 已经存在的话，频数加1
            } else {
                map.put(num, 1);// 不存在的话先填进去
            }
        }

        // 使用数据结构PriorityQueue构建堆，实现自定义的排序接口让频数小的在堆顶
        PriorityQueue<Integer> a = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a,Integer b){
                return map.get(a) - map.get(b);
            }
        });

        // 遍历哈希表，实现上述的思路，核心是——用最小堆保存频率最大的k个元素
        for (Integer key : map.keySet()) {// 这里的写法： keySet() 方法可以与 for-each 循环一起使用，用来遍历迭代 HashMap 中的所有键
            if (a.size() < k) {
                a.add(key); // 少的加进去
            } else if (map.get(key) > map.get(a.peek())) {
                a.remove(); // 比较新来的元素与堆顶元素的频率，把大的塞进去，小的丢掉
                a.add(key);
            }
        }

        // 取出最小堆中的元素，构建返回用的答案数组
        int[] res = new int[k];
        int i = 0;
        while (!a.isEmpty()) {
            res[i++] = a.poll();
        }
        return res;
    }
}
// @lc code=end
