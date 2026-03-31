package Theoretical_foundation.Sort;

// ====================== 核心思路 ======================
// 类似打扑克牌插牌，左边始终有序，每次把当前元素插入正确位置
//
// 时间复杂度：O(n^2)
// 空间复杂度：O(1)
// 稳定排序
// ======================================================

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > cur) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }
    }

    public static void main(String[] args) {
        InsertionSort test = new InsertionSort();
        int[] nums = new int[]{2, 5, 9, 3, 7, 4};
        test.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
