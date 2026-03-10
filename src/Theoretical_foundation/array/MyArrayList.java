package Theoretical_foundation.array;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E> {
    private E[] data; // 真正存储数据的底层数组
    private int size; // 实际存放元素个数
    private static final int INIT_CAP = 1; // 默认初始容量

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCap) {
        data = (E[]) new Object[initCap];
        size = 0;
    }

    public void addLast(E e) {
        int cap = data.length;
        if (size == cap) {
            resize(cap * 2);
        }
        data[size] = e;
        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);

        int cap = data.length;
        if (cap == size) {
            resize(cap * 2);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int cap = data.length;
        if (size == cap / 4) {
            resize(cap / 2);
        }
        E deleteElement = data[size - 1];
        // 必须给最后一个元素置为 null，否则会内存泄漏
        data[size - 1] = null;
        size--;
        return deleteElement;
    }

    public E remove(int index) {
        checkElementIndex(index);
        int cap = data.length;
        if (size == cap / 4) {
            resize(cap / 2);
        }
        E deleteElement = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return deleteElement;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }

    public E set(int index, E e) {
        checkElementIndex(index);
        E oldElement = data[index];
        data[index] = e;
        return oldElement;
    }

    //工具类
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    // 检查 index 索引位置是否可以添加元素
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }

    // 检查 index 索引位置是否可以存在元素
    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }

    private void display() {
        System.out.println("size=" + size + ", cap=" + data.length);
        //在 Java 里，直接打印数组 → 输出的是【内存地址】，不是内容！
        //必须用 Arrays.toString(数组) → 才能看到里面的元素！
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>(3);
        arr.display();

        for (int i = 0; i <= 5; i++) {
            arr.addLast(i);
        }
        arr.display();

        arr.add(1, 9);
        arr.display();

        arr.addFirst(100);
        arr.display();
        int val = arr.removeLast();

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
