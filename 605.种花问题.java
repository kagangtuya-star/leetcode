
class Main {
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        int[] flowerbed = {1,0,0,0,1};
        int n = 2;
        // Get the answer
        int[] answer = solution.twoSum(flowerbed,n);
        // Print the answer
        System.out.println("answer");
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */
// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*在首位和尾位都填上一个0，这样所有的元素就都有前一个数和后一个数了，只需要寻找三
        个连续0的情况有多少个就行了，该个数就是可插花朵的最大值*/ 
        int count =0;
        int a=flowerbed.length;
        //新数组创建
        int[] newflowerbed = new int[a+2];
        newflowerbed[0]=0;
        newflowerbed[a+1]=0;
        //老数组复制新数组中间
        for (int i=1;i<newflowerbed.length-2;i++) {
            newflowerbed[i]=flowerbed[i-1];
        }

        //遍历，寻找三个连续的0
        for (int i=1;i<newflowerbed.length-1;i++) {
            if(newflowerbed[i]==0 && newflowerbed[i-1]==0 && newflowerbed[i+1]==0)
            {
                newflowerbed[i]=1;
                count++;
            }
        }
        return n<=count;

    }
}
// @lc code=end

