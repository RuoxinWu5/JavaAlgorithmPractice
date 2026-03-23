package linkedList;

// ====================== 核心思路 ======================
// 题目：O(1) 时间复杂度删除链表指定节点
// 解法：不遍历找前驱，直接复制后继节点覆盖当前节点
// 1. 若待删节点不是尾节点：用下一个节点的值和指针覆盖它，O(1) 完成删除
// 2. 若待删节点是尾节点：只能从头遍历找到前驱，断开连接
// 3. 若链表只有一个节点（头节点=待删节点）：直接返回 null

// 时间复杂度：平均 O(1)，最坏 O(n)（删除尾节点）
// 空间复杂度：O(1)
// ======================================================

public class DeleteNodeInLinkedList {
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        // write code here
        if (head == null || tobeDelete == null) {
            return null;
        }
        if (tobeDelete.next == null) {
            if (head == tobeDelete) {
                return null;
            } else {
                ListNode cur = head;
                while (cur.next != tobeDelete) cur = cur.next;
                cur.next = null;
            }
        } else {
            ListNode temp = tobeDelete.next;
            tobeDelete.val = temp.val;
            tobeDelete.next = temp.next;
        }
        return head;
    }
}
