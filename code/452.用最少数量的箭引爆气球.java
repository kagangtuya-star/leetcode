import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 实现接口的自定义排序——按右边界进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        // 先对数组进行排序，然后往后查找某个气球的左边界大于当前气球的右边界的，就需要再射一箭
        // 右边界位置最靠左的气球是 points[0]
        int a = points[0][1];
        int result = 1;
        // 遍历
        for (int[] temp : points) {
            if (temp[0] > a) {
                a = temp[1];// 气球炸了
                ++result;
            }
        }
        return result;
    }
}
// @lc code=end
