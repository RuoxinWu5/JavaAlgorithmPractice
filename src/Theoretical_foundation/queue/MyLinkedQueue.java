package Theoretical_foundation.queue;

import java.util.LinkedList;

public class MyLinkedQueue<E> {
    private final LinkedList<E> queue = new LinkedList<>();

    public void push(E e) {
        queue.addLast(e);
    }

    public E pop() {
        return queue.removeFirst();
    }

    public E peek() {
        return queue.getFirst();
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.peek()); // 1
        System.out.println(queue.pop()); // 1
        System.out.println(queue.pop()); // 2
        System.out.println(queue.peek()); // 3
    }
}
