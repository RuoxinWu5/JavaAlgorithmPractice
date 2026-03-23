package linkedList;

public class MergeTwoSortedLists {

    // ====================== 核心思路 ======================
    // 题目：合并两个递增排序的链表，合并后依然有序
    // 解法：双指针迭代法，原地合并，不占用额外空间
    // 1. 创建虚拟头节点，方便统一处理链表头部
    // 2. 用双指针同时遍历两个有序链表
    // 3. 每次取较小值的节点接入结果链表
    // 4. 一个链表遍历完后，直接拼接另一个链表剩余部分

    // 时间复杂度：O(n) 遍历一次两个链表
    // 空间复杂度：O(1) 仅使用常数个指针变量
    // ======================================================

    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }
        if (pHead1 != null) {
            cur.next = pHead1;
        } else {
            cur.next = pHead2;
        }
        return res.next;
    }

    // ====================== 核心思路 ======================
    // 题目：合并两个递增排序的链表，合并后依然有序
    // 解法：递归法（简洁优雅）
    // 1. 递归终止条件：一个链表为空，直接返回另一个链表
    // 2. 比较两个链表头节点值大小
    // 3. 值小的节点作为当前头，它的 next 指向剩余部分递归合并的结果
    // 4. 层层返回，自动拼接成完整有序链表

    // 时间复杂度：O(n) 每个节点递归处理一次
    // 空间复杂度：O(n) 递归调用栈占用空间
    // ======================================================

    public ListNode Merge1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) return pHead2;
        if (pHead2 == null) return pHead1;
        if (pHead1.val < pHead2.val) {
            pHead1.next = Merge1(pHead1.next, pHead2);
            return pHead1;
        } else {
            pHead2.next = Merge1(pHead1, pHead2.next);
            return pHead2;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists test = new MergeTwoSortedLists();
        ListNode pHead1 = new ListNode(-1);
        pHead1.next = new ListNode(2);
        pHead1.next.next = new ListNode(4);
        ListNode pHead2 = new ListNode(1);
        pHead2.next = new ListNode(3);
        pHead2.next.next = new ListNode(4);
        ListNode listNode = test.Merge1(pHead1, pHead2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
