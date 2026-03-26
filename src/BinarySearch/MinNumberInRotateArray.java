package BinarySearch;

// ====================== JZ11 旋转数组的最小数字 ======================
// 二分查找 —— 开区间模板 (-1, len)
// 核心：
// 1. 当 nums[mid] > nums[right] → 最小值在右边
// 2. 当 nums[mid] < nums[right] → 最小值在左边
// 3. 当 nums[mid] == nums[right] → 无法判断，只能 right--（去重）

// 时间复杂度：O(log n) 最坏 O(n)
// 空间复杂度：O(1)
// ====================================================================

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] nums) {
        // write code here
        int start = -1;
        int end = nums.length;
        // 闭区间是[0,n-1], 开区间(-1,n)
        while (start + 1 < end) {
            int mid = (end + start) / 2;
            if (nums[mid] > nums[end - 1]) {
                // 最小值在右边
                start = mid;
            } else if (nums[mid] < nums[end - 1]) {
                // 最小值在左边或mid
                end = mid + 1;
            } else {
                // 相等！无法判断，只能缩小右边界（去重）
                end--;
            }
        }
        return nums[end];
    }

    public static void main(String[] args) {
        MinNumberInRotateArray test = new MinNumberInRotateArray();
        int[] nums = new int[]{1, 0, 1, 1, 1};
        int[] nums1 = new int[]{2, 2, 2, 1, 2};
        int[] nums2 = new int[]{3, 4, 5, 1, 2};
        int[] nums3 = new int[]{3, 100, 200, 3};

        System.out.println(test.minNumberInRotateArray(nums));
        System.out.println(test.minNumberInRotateArray(nums1));
        System.out.println(test.minNumberInRotateArray(nums2));
        System.out.println(test.minNumberInRotateArray(nums3));
    }
}
