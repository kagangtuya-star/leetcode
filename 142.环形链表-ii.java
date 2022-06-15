/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 * 对于链表找环路的问题，有一个通用的解法——快慢指针（Floyd 判圈法）。
 * 给定两个指针，分别命名为 slow 和 fast，起始位置在链表的开头。
 * 每次 fast 前进两步，slow 前进一步。如果 fast可以走到尽头，
 * 那么说明没有环路；如果 fast 可以无限走下去，那么说明一定有环路，
 * 且一定存在一个时刻 slow 和 fast 相遇。当 slow 和 fast 第一次相遇时，
 * 我们将 fast 重新移动到链表开头，并让 slow 和 fast 每次都前进一步。
 * 当 slow 和 fast 第二次相遇时，相遇的节点即为环路的开始点。
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head; // 快慢指针
        // 第一次相遇
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            } // 快指针走完说明没有环

            fast = fast.next.next; // 分别前进2或1个位置
            slow = slow.next;

            if (fast == slow)
                break;
        }
        fast = head;// 复位快指针，进行第二次相遇

        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow; // 最后二者都指向了环开始的节点

    }
}
// @lc code=end
