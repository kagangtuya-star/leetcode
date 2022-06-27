import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 * 
 * 
 */

// @lc code=start
/*最暴力解法，直接调库排序
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }
}*/
/*优先队列，更为快速的解法
 * 维护一个有 K 个元素的最小堆：如果当前堆不满，直接添加；
堆满的时候，如果新读到的数小于等于堆顶，肯定不是我们要找的
元素，只有新遍历到的数大于堆顶的时候，才将堆顶拿出，然后放
入新读到的数，进而让堆自己去调整内部结构。
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        //使用java的最小堆数据结构PriorityQueue，顺便设置初始最大值防止占用过多
        PriorityQueue<Integer> min = new PriorityQueue<>(k,Comparator.comparing(a->a));
        //添加元素
        for(int i=0;i<k;i++){
            min.offer(nums[i]);
        }
        //对堆进行遍历，如果被遍历的元素比堆顶大，就弹出堆顶，把这个塞进去
        for(int i=k;i<len;i++){
            Integer topnum = min.peek();//取出
            if(nums[i]>topnum){
                min.poll();//弹出堆顶
                min.offer(nums[i]);//塞进去
            }
        }
        return min.peek();
    }
}


// @lc code=end

