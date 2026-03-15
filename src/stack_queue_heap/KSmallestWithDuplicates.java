package stack_queue_heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

// ====================== 核心思路 ======================
// 题目要求：找出数组中不去重的最小 k 个数
// 解法：使用【最大堆】维护当前最小的 k 个元素
// 1. 维护一个大小为 k 的最大堆，堆顶始终是堆内最大值
// 2. 遍历数组，每个元素都加入堆
// 3. 当堆大小超过 k 时，弹出堆顶（淘汰最大的，保留小的）
// 4. 遍历结束后，堆中剩下的就是最小 k 个数

// 时间复杂度：O(n log k)，每个元素入堆出堆耗时 log k
// 空间复杂度：O(k)，堆只保存 k 个元素
// ======================================================

public class KSmallestWithDuplicates {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param input int整型一维数组
     * @param k     int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // write code here
        if (input == null || input.length == 0 || input.length < k) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);//默认小顶堆
        for (int i : input) {
            maxHeap.add(i);
            if (maxHeap.size() == k + 1) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        KSmallestWithDuplicates test = new KSmallestWithDuplicates();
        System.out.println(test.GetLeastNumbers_Solution(input, k));
    }
}
