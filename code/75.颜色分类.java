/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 * 
 * 正常解法是双指针或者排序算法，不过看到一个邪道解法
 * 
 * [2 0 2 1 1 1 0] 
-> [2 2 2 2 2 2 2] 先全填上2
-> [1 1 1 1 1 2 2] 统计下0和1的个数之和(作为数字1的右侧边界)，然后填上1
-> [0 0 1 1 1 2 2] 统计下0的个数（作为数字0的右侧边界），然后填上0
链接：https://leetcode.cn/problems/sort-colors/solution/java100-94-yi-ci-bian-li-by-jade_xie-v5tl/

如同题目名字颜色分类，这个法子跟涂色一样
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        //数字的边界，或者说有几个
        int one =0,two=0,zero=0;
        int len=nums.length;

        for(int i=0;i<len;i++){
            int temp = nums[i];
            nums[two]=2;//实际上two的值和ei一样，这里方便理解。全部填上2、
            two++;

            if(temp<=1){
                nums[one]=1;
                one++;
            }
            if(temp==0){
                nums[zero]=0;
                zero++;
            }

        }
    }
}
// @lc code=end

