package Theoretical_foundation.Sort;

// ====================== 核心思路 ======================
// 题目：冒泡排序
// 思想：每一轮把当前最大的数“冒泡”到末尾
// 优化：如果某一轮没有交换，说明已经有序，提前结束
//
// 时间复杂度：O(n^2)
// 空间复杂度：O(1)
// 稳定排序
// ======================================================

import java.util.Arrays;

public class BubbleSort {
    public int[] sort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            boolean notSwapFlag = true;
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    notSwapFlag = false;
                }
            }
            if (notSwapFlag) break;
        }
        return nums;
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        BubbleSort test = new BubbleSort();
        int[] nums = new int[]{2, 5, 9, 3, 7, 4};
        System.out.println(Arrays.toString(test.sort(nums)));
    }
}
