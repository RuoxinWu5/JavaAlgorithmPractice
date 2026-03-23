package linkedList;

// ====================== 核心思路 ======================
// 题目：找到链表中环的入口节点，无环则返回null
// 解法：快慢指针法（龟兔赛跑）
// 1. 快指针走2步，慢指针走1步，相遇则说明有环
// 2. 快指针回到链表头部，快慢指针都走1步
// 3. 再次相遇的位置，就是环的入口

// 时间复杂度 O(n)：
// 快慢指针最多遍历整个链表两次（找相遇点+找入口点），常数次遍历仍为线性复杂度
// 空间复杂度 O(1)：
// 仅使用 fast、slow 两个指针，无额外辅助空间，是原地算法
// ======================================================

public class EntryNodeOfLinkedListLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //快慢指针法（龟兔赛跑法）使用双指针，一个快指针 fast 每次移动两个节点，一个慢指针 slow 每次移动一个节点。因为存在环，所以两个指针必定相遇在环中的某个节点上。
        if (pHead == null) return null;
        ListNode pFast = pHead, pSlow = pHead;

        // 第一步：判断是否有环
        while (pFast != null && pFast.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if (pFast == pSlow) {
                break;
            }
        }

        // 无环直接返回
        if(pFast == null || pFast.next == null){
            return null;
        }

        // 第二步：找环入口
        pFast = pHead;
        while (pFast != pSlow) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        return pFast;
    }
}
