package Theoretical_foundation.Sort;

// ====================== 核心思路 ======================
// 快速排序：分治思想
// 选择一个基准值 pivot
// 左边都小于 pivot，右边都大于 pivot
// 递归左右区间
//
// 时间复杂度：平均 O(nlogn) 最坏 O(n^2)
// 空间复杂度：O(logn)
// ======================================================

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        QuickSort test = new QuickSort();
        test.quickSort(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int first = start;
        while (start < end) {
            while (start < end && nums[end] >= pivot) end--; // 控制右指针向左移动，找到小于基准元素的那个数
            while (start < end && nums[start] <= pivot) start++; // 控制左指针向右移动，找到大于基准元素的那个数
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        nums[first] = nums[start];
        nums[start] = pivot;
        return start;
    }
}
