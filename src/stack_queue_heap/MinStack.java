package stack_queue_heap;

import java.util.Stack;

// ====================== 核心思路 ======================
// 题目：实现包含 min 函数的栈，要求 push、pop、top、min 都是 O(1)
// 解法：用两个栈
// 1. stack：正常存储所有元素
// 2. smallStack：同步存储【当前栈的最小值】
// 每压入一个数，最小栈就压入当前最小；弹出时两个栈一起弹

// 时间复杂度：O(1)，所有操作都是常数时间
// 空间复杂度：O(n)，需要一个辅助栈
// ======================================================

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> smallStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (smallStack.isEmpty()) {
            smallStack.push(node);
        } else {
            Integer peek = smallStack.peek();
            if (peek < node) {
                smallStack.push(peek);
            } else {
                smallStack.push(node);
            }
        }
    }

    public void pop() {
        stack.pop();
        smallStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return smallStack.peek();
    }

    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(-1);
        test.push(2);
        System.out.println(test.min());
        System.out.println(test.top());
        test.pop();
        test.push(1);
        System.out.println(test.top());
        System.out.println(test.min());

    }
}
