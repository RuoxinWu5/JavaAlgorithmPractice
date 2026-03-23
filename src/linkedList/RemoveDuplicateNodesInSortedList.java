package linkedList;

// ====================== 核心思路 ======================
// 题目：删除排序链表中所有重复的节点（重复节点不保留）
// 解法：递归法，利用排序链表重复节点相邻的特性
// 1. 递归终止条件：节点为空 或 只有一个节点，直接返回
// 2. 如果当前节点与下一个节点值相等：跳过所有重复节点，递归处理后续节点
// 3. 如果不相等：保留当前节点，递归处理下一个节点并连接
// 4. 最终返回去重后的链表头节点

// 时间复杂度：O(n) 遍历一次链表
// 空间复杂度：O(n) 递归调用栈空间
// ======================================================

public class RemoveDuplicateNodesInSortedList {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);
        RemoveDuplicateNodesInSortedList test = new RemoveDuplicateNodesInSortedList();
        ListNode res = test.deleteDuplication(listNode);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
