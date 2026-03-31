package Theoretical_foundation.Sort;

// ====================== 核心思路 ======================
// 每轮选择最小值，放到当前位置
//
// 时间复杂度：O(n^2)
// 空间复杂度：O(1)
// 不稳定
// ======================================================

import java.util.Arrays;

public class SelectionSort {
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) minIndex = j;
            }
            if (minIndex != i) swap(nums, minIndex, i);
        }
        return nums;
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SelectionSort test = new SelectionSort();
        int[] nums = new int[]{2, 5, 9, 3, 7, 4};
        System.out.println(Arrays.toString(test.sort(nums)));
    }
}
