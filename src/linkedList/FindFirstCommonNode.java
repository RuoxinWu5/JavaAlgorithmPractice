package linkedList;

// ====================== 核心思路 ======================
// 题目：寻找两个无环单向链表的第一个公共节点
// 解法：双指针浪漫相遇法（最优解）
// 1. 定义两个指针 cur1、cur2 分别从两个链表头出发
// 2. 一个指针走到末尾后，指向另一个链表的头部继续走
// 3. 最终两个指针会在第一个公共节点相遇（或同时为null）
// 原理：路程相等，速度相同，必然相遇

// 时间复杂度：O(n) 两个指针各遍历两次链表
// 空间复杂度：O(1) 仅使用两个指针，无额外空间
// ======================================================

public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1, cur2 = pHead2;
        while (cur1 != cur2) {
            cur1 = (cur1 == null) ? pHead2 : cur1.next;
            cur2 = (cur2 == null) ? pHead1 : cur2.next;
            // if (cur1 != null) {
            //     cur1 = cur1.next;
            // } else { // 走到null切换走另一个
            //     cur1 = pHead2;
            // }
            // if (cur2 != null) {
            //     cur2 = cur2.next;
            // } else {
            //     cur2 = pHead1;
            // }
        }
        return cur1;
    }
}
