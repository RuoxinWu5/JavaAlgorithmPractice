package linkedList;

// ====================== 核心思路 ======================
// 题目：复制复杂链表（包含 next 和 random 指针）
// 解法：原地三步法（空间 O(1)）
// 1. 在每个原节点后面插入一个克隆节点
// 2. 根据原节点的 random 给克隆节点赋值 random
// 3. 拆分原链表与克隆链表，得到深拷贝结果

// 时间复杂度：O(n)
// 空间复杂度：O(1)
// ======================================================

public class CopyRandomList {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode cur = pHead;

        // 每个节点后面接一个复制的节点
        while (cur != null) {
            RandomListNode curCopy = new RandomListNode(cur.label);
            curCopy.next = cur.next;
            cur.next = curCopy;
            cur = curCopy.next;
        }
        // 给复制的节点赋random指针
        cur = pHead;
        while (cur != null) {
            RandomListNode curCopy = cur.next;
            if (cur.random != null) curCopy.random = cur.random.next;
            cur = curCopy.next;
        }

        // 剪出curCopy
        RandomListNode res = pHead.next;
        cur = pHead;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return res;
    }
}
