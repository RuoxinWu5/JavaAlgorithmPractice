package stack_queue_heap;

import java.util.PriorityQueue;

// ====================== 核心思路 ======================
// 题目：不停插入数据流，随时获取中位数
// 中位数：奇数个取中间，偶数个取中间两数平均值
// 解法：用两个堆维护数据流
// 1. leftMaxHeap：大顶堆，存放较小的一半数，堆顶 = 左边最大
// 2. rightMinHeap：小顶堆，存放较大的一半数，堆顶 = 右边最小
// 3. 保证：左边数量 = 右边数量 或 左边 = 右边 + 1
// 4. 奇数个：中位数 = 左边堆顶
//    偶数个：中位数 = (左堆顶 + 右堆顶) / 2

// 时间复杂度：Insert O(log n)，GetMedian O(1)
// 空间复杂度：O(n)
// ======================================================

public class FindMedianFromDataFlow {
    private PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
    private int N = 0;

    public void Insert(Integer num) {
        N++;
        if (N % 2 == 0) {
            leftMaxHeap.add(num);
            rightMinHeap.add(leftMaxHeap.poll());
        } else {
            rightMinHeap.add(num);
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public Double GetMedian() {
        if (N % 2 == 0) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        } else {
            return (double) leftMaxHeap.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataFlow test = new FindMedianFromDataFlow();
        test.Insert(5);
        System.out.println(test.GetMedian());
        test.Insert(2);
        System.out.println(test.GetMedian());
        test.Insert(3);
        System.out.println(test.GetMedian());
        test.Insert(4);
        System.out.println(test.GetMedian());
        test.Insert(1);
        System.out.println(test.GetMedian());
        test.Insert(6);
        System.out.println(test.GetMedian());
        test.Insert(7);
        System.out.println(test.GetMedian());
        test.Insert(0);
        System.out.println(test.GetMedian());
        test.Insert(8);
        System.out.println(test.GetMedian());
    }
}
