package Theoretical_foundation.stack;

import java.util.ArrayList;

public class MyArrayStack<E> {
    private ArrayList<E> stack = new ArrayList<>();

    public void push(E e) {
        stack.add(e);
    }

    public E pop() {
        return stack.remove(stack.size() - 1);
    }

    public E peek() {
        return stack.get(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        MyArrayStack<Integer> stack = new MyArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek()); // 3
        System.out.println(stack.pop()); // 3
        System.out.println(stack.peek()); // 2
    }
}
