package linkedList;

// ====================== 核心思路 ======================
// 题目：输出链表的倒数第k个节点
// 解法：快慢指针（双指针），一次遍历搞定，空间 O(1)
// 1. 快指针先走 k-1 步，指向第k个节点
// 2. 若快指针无法走完k-1步，说明链表长度不足k，返回null
// 3. 然后快慢指针同时向后走，直到快指针到达链表尾部
// 4. 此时慢指针指向的就是倒数第k个节点

// 时间复杂度：O(n) 一次遍历
// 空间复杂度：O(1) 仅用两个指针
// ======================================================

public class FindKthToTailInLinkedList {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null || k == 0) return null;
        ListNode pTail = pHead;
        while (pTail.next != null && k > 1) {
            pTail = pTail.next;
            k--;
        }
        if (k > 1) return null;
        while (pTail.next != null) {
            pHead = pHead.next;
            pTail = pTail.next;
        }
        return pHead;
    }
}
