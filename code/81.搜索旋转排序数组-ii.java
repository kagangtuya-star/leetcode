import java.rmi.server.RemoteRef;

/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 * 
 * 仍然是二分查找，但将旋转数组的两段有序性分开来进行
 * https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/solution/gong-shui-san-xie-xiang-jie-wei-he-yuan-xtam4/
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        //空数组直接退出
        if(nums==null || nums.length==0){
            return false;
        }
        int left=0,right=nums.length-1,mid;
        //迭代查找
        while(right>=left){
            mid=left +(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            /* 10111 和 1110111101 这种。此种情况下 
            nums[start] == nums[mid]，分不清到底是前面
            有序还是后面有序，此时 start++。去掉一个重复的干扰项
            */
            if(nums[mid]==nums[left]){
                left++;
                continue;
            }

            //前半截有序，如2 3 4 5 6 7 1 ，如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找
            if(nums[left]<nums[mid]){
                if(nums[mid]>target && nums[left]<=target){
                    right=mid-1;
                }
                else {
                    left=mid+1;
                }
            }
            //后半截有序，如6 7 1 2 3 4 5 这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找
            else {
                if(nums[mid]<target && nums[right]>=target){
                    left=mid+1;
                }
                else {
                    right=mid-1;
                }
            }
        }
        return false;
    }
}
// @lc code=end

