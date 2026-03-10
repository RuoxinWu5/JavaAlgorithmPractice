package Theoretical_foundation.linkedList;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> {
    // 虚拟头尾节点
    final private Node<E> head, tail;
    private int size;

    public MyDoublyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    // Node 是【静态内部类】, Node 只给链表用，是私有工具，封装在内部更安全。
    // static 作用：属于【类】，不属于【对象】
    // static 使用场景：①内部类。②常量（共用）。③工具方法、不依赖对象的方法。
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val) {
            this.val = val;
        }
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> temp = tail.prev;

        newNode.prev = temp;
        newNode.next = tail;

        temp.next = newNode;
        tail.prev = newNode;

        size++;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> temp = head.next;

        newNode.prev = head;
        newNode.next = temp;

        head.next = newNode;
        temp.prev = newNode;

        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(e);
            return;
        }

        Node<E> newNode = new Node<>(e);
        Node<E> p = getNode(index);
        Node<E> temp = p.prev;

        newNode.prev = temp;
        newNode.next = p;

        temp.next = newNode;
        p.prev = newNode;

        size++;
    }

    public E removeLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> deleteNode = tail.prev;
        Node<E> temp = deleteNode.prev;

        temp.next = tail;
        tail.prev = temp;

        deleteNode.prev = null;
        deleteNode.next = null;

        size--;
        return deleteNode.val;
    }

    public E removeFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> deleteNode = head.next;
        Node<E> temp = deleteNode.next;

        head.next = temp;
        temp.prev = head;
        deleteNode.prev = null;
        deleteNode.next = null;

        size--;
        return deleteNode.val;
    }

    public E remove(int index) {
        checkElementIndex(index);
        Node<E> deleteNode = getNode(index);
        Node<E> temp = deleteNode.prev;

        temp.next = deleteNode.next;
        deleteNode.next.prev = temp;

        deleteNode.prev = null;
        deleteNode.next = null;

        size--;
        return deleteNode.val;
    }

    public E get(int index) {
        checkElementIndex(index);
        Node<E> p = getNode(index);
        return p.val;
    }

    public E getFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }

    public E set(int index, E e) {
        checkElementIndex(index);
        Node<E> p = getNode(index);
        E oldValue = p.val;
        p.val = e;
        return oldValue;
    }

    // 工具函数
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

    private void display(){
        System.out.println("size = "+size);
        for (Node<E> p=head.next;p!=tail;p=p.next){
            System.out.print(p.val +" <-> ");
        }
        System.out.println("null");
        System.out.println();
    }

    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();
        list.addLast(1);
        list.display();
        list.addLast(2);
        list.display();
        list.addLast(3);
        list.display();
        list.addFirst(0);
        list.display();
        list.add(2, 100);

        list.display();
        // size = 5
        // 0 <-> 1 <-> 100 <-> 2 -> 3 -> null
    }
}
