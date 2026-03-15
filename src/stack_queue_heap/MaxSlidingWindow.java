package stack_queue_heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

// ====================== 核心思路 ======================
// 题目：求滑动窗口中的最大值
// 解法：利用最大堆（大顶堆）动态维护窗口内的最大值
// 1. 先将第一个窗口的元素加入最大堆，堆顶即为当前最大值
// 2. 窗口向右滑动，移除左端离开窗口的元素，加入右端新进入的元素
// 3. 每次取堆顶作为当前窗口最大值，加入结果集

// 时间复杂度：O(n*k) 堆移除元素需要遍历查找，效率较低
// 空间复杂度：O(k) 堆最多存储 k 个元素
// ======================================================

public class MaxSlidingWindow {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param num  int整型一维数组
     * @param size int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        // write code here
        if (num.length == 0 || size <= 0 || size > num.length) {
            return new ArrayList<>();
        }
        int n = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < size; i++) {
            maxHeap.add(num[i]);
        }
        res.add(maxHeap.peek());
        for (int i = 0, j = i + size; j < n; i++, j++) {
            maxHeap.remove(num[i]);
            maxHeap.add(num[j]);
            res.add(maxHeap.peek());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        MaxSlidingWindow test = new MaxSlidingWindow();
        System.out.println(test.maxInWindows(num, size));
    }
}
