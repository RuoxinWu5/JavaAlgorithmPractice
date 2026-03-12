package Theoretical_foundation.stack;

import java.util.LinkedList;

public class MyLinkedStack<E> {
    //stack 是栈的底层容器,从创建栈开始，stack 就固定指向这个链表，全程不会、也不能换其他容器
    //很多人会误以为[加了final，stack 就不能 push、pop 了] —— 这是完全错误的！
    //final 只限制「list 引用不能变」，不限制「list 内部的元素操作」
    private final LinkedList<E> stack = new LinkedList<>();

    public void push(E e) {
        stack.addLast(e);
    }

    public E pop() {
        return stack.removeLast();
    }

    public E peek() {
        return stack.getLast();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek()); // 3
        System.out.println(stack.pop()); // 3
        System.out.println(stack.peek()); // 2
    }
}
