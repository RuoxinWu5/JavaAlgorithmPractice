package Theoretical_foundation.Sort;

import java.util.Arrays;
import java.util.Scanner;

// ====================== 核心思路 ======================
// 归并排序：分治 + 合并
// 不断二分，分别排序左右区间，合并两个有序数组
//
// 时间复杂度：O(nlogn)
// 空间复杂度：O(n)
// 稳定排序
// ======================================================

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        MergeSort test = new MergeSort();
        test.mergeSort(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] res = new int[end - start + 1];
        int s1 = start, s2 = mid + 1;
        int k = 0;
        while (s1 <= mid && s2 <= end) {
            if (nums[s1] <= nums[s2]) {
                res[k++] = nums[s1++];
            } else {
                res[k++] = nums[s2++];
            }
        }
        while (s1 <= mid) res[k++] = nums[s1++];
        while (s2 <= end) res[k++] = nums[s2++];

        for (int i = 0; i < res.length; i++) {
            nums[start + i] = res[i];
        }
    }
}
