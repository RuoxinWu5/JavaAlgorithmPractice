package BinarySearch;

// ====================== JZ53 数字在升序数组中出现的次数 ======================
// 解法：二分查找（lowerBound 模板）
// 核心思路：
// 1. 使用 lowerBound 找到第一个 >= k 的位置（左边界）
// 2. 使用 lowerBound 找到第一个 >= k+1 的位置，减一就是最后一个 =k 的位置（右边界）
// 3. 次数 = 右边界 - 左边界 + 1

// 时间复杂度：O(log n)
// 空间复杂度：O(1)
// ============================================================================

public class GetNumberOfK {

    public int getNumberOfK(int[] nums, int k) {
        // write code here
        int first = lowerBound(nums, k);
        if (first == nums.length || nums[first] != k) return 0;
        int last = lowerBound(nums, k + 1) - 1;
        return last - first + 1;
    }

    // ====================== lowerBound 开区间模板 ======================
    // 功能：返回数组中第一个 >= target 的下标
    // 开区间 (-1, nums.length)
    // ==================================================================

    private int lowerBound(int[] nums, int k) {
        int start = -1;
        int end = nums.length;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        GetNumberOfK test = new GetNumberOfK();
        System.out.println(test.getNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
        System.out.println(test.getNumberOfK(new int[]{1, 3, 4, 5}, 6));
    }
}
