package Theoretical_foundation.Sort;

// ====================== 核心思路 ======================
// 堆排序：大根堆
// 建堆，堆顶最大值交换到末尾，调整剩余堆
//
// 时间复杂度：O(nlogn)
// 空间复杂度：O(1)
// ======================================================

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        HeapSort test = new HeapSort();
        test.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void heapSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;

        // 从最后一个非叶子节点开始，逐步构建大根堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // 逐一交换堆顶元素和末尾元素，调整堆
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);// 顶部元素向下沉
        }
    }

    private void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        // 选出子节点里最大的记录在 largest 里，供后面交换
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        // 交换后，继续对交换的位置进行判断
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, n, largest);// 递归
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
