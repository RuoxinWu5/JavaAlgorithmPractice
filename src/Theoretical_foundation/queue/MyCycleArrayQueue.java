package Theoretical_foundation.queue;

import Theoretical_foundation.array.CycleArray;

public class MyCycleArrayQueue<E> {
    private CycleArray<E> queue = new CycleArray<>();

    public void push(E e) {
        queue.addLast(e);
    }

    public void pop() {
        queue.removeFirst();
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
