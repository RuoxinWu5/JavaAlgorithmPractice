package linkedList;

import java.util.ArrayList;
import java.util.Stack;

// ====================== 核心思路 ======================
// 题目：从尾到头打印链表，用数组返回结果
// 解法：利用栈 “先进后出” 的特性实现逆序
// 1. 遍历链表，把所有节点值依次压入栈
// 2. 依次弹出栈中元素，存入 ArrayList
// 3. 最终得到的集合就是链表从尾到头的顺序

// 时间复杂度：O(n) 遍历两次链表
// 空间复杂度：O(n) 需要一个栈存储所有节点
// ======================================================


public class PrintLinkedListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        PrintLinkedListFromTailToHead test = new PrintLinkedListFromTailToHead();
        System.out.println(test.printListFromTailToHead(listNode));
    }

}
