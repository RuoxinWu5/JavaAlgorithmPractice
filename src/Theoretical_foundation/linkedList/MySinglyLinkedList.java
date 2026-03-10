package Theoretical_foundation.linkedList;

import java.util.NoSuchElementException;


public class MySinglyLinkedList<E> {

    // head 是虚拟头节点，tail 是真实尾节点
    private final Node<E> head;
    private Node<E> tail;
    private int size;

    public MySinglyLinkedList() {
        this.head = new Node<>(null);
        this.tail = head;
        this.size = 0;
    }

    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
            this.next = null;
        }
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head.next;
        head.next = newNode;
        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);
        if (index == 0) {
            addFirst(e);
            return;
        }
        if (index == size) {
            addLast(e);
            return;
        }
        Node<E> newNode = new Node<>(e);
        Node<E> p = getNode(index - 1);
        newNode.next = p.next;
        p.next = newNode;
        size++;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            E deleteVal = tail.val;
            tail = head;
            head.next = null;
            size--;
            return deleteVal;
        } else {
            Node<E> temp = getNode(size - 2);
            E deleteVal = tail.val;
            temp.next = null;
            tail = temp;

            size--;
            return deleteVal;
        }
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> temp = head.next;
        E deleteVal = temp.val;
        head.next = temp.next;
        temp.next = null;
        if (size == 1) {
            tail = head;
        }
        size--;
        return deleteVal;
    }

    public E remove(int index) {
        checkElementIndex(index);
        if (index == size - 1) {
            return removeLast();
        }
        Node<E> temp = getNode(index - 1);
        Node<E> deleteNode = temp.next;
        temp.next = deleteNode.next;
        deleteNode.next = null;

        size--;
        return deleteNode.val;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.val;
    }

    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).val;
    }

    public E set(int index, E e) {
        checkElementIndex(index);
        Node<E> temp = getNode(index);
        E oldVal = temp.val;
        temp.val = e;
        return oldVal;
    }

    //工具函数
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> temp = head.next;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }


    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public static void main(String[] args) {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);
        list.add(2, 5);

        System.out.println(list.removeFirst()); // 2
        System.out.println(list.removeLast()); // 4
        System.out.println(list.remove(1)); // 5

        System.out.println(list.getFirst()); // 1
        System.out.println(list.getLast()); // 3
        System.out.println(list.get(1)); // 3
    }
}
