package stack_queue_heap;

import java.util.Stack;

// ====================== 核心思路 ======================
// 题目：用两个栈实现队列
// 队列：先进先出 FIFO
// 栈：先进后出 FILO
// 解法：
// 1. stack1 只负责入队（push）
// 2. stack2 只负责出队（pop）
// 3. 当 stack2 为空时，一次性把 stack1 所有元素倒入 stack2
// 这样 stack2 弹出顺序就变成了队列顺序

// 时间复杂度：均摊 O(1)
// 空间复杂度：O(n)
// ======================================================

public class QueueByTwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Integer node = stack1.pop();
                stack2.push(node);
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueByTwoStack test = new QueueByTwoStack();
        test.push(2);
        System.out.println(test.pop());
        test.push(1);
        System.out.println(test.pop());
    }
}
