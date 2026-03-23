package linkedList;

import java.util.Stack;

// ====================== 核心思路 ======================
// 题目：反转单链表，返回反转后的新头节点
// 解法：迭代法（三指针反转），原地修改链表指向，不占用额外空间
// 1. 定义三个指针 pre、cur、nxt 分别表示前驱、当前、后继节点
// 2. 遍历链表，逐个将当前节点的 next 指向前驱节点
// 3. 不断更新指针位置，直到遍历结束
// 4. 最终 pre 指向新的头节点

// 时间复杂度：O(n) 遍历一次链表
// 空间复杂度：O(1) 只用了常数个指针变量
// ======================================================

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        // write code here
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static void main(String[] args) {
        ReverseList test = new ReverseList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = test.ReverseList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
