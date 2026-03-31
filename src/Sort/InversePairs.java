package Sort;

// ====================== 核心思路 ======================
// 题目：数组中的逆序对
// 解法：归并排序 + 逆序对统计
// 核心思想：在 merge 过程中统计跨区间逆序对
//
// 当 nums[l1] > nums[l2]，由于左右两部分已经分别有序，说明：
// nums[l1...mid] 都 > nums[l2]
// 所以一次性增加mid - l1 + 1
//
// 时间复杂度：O(n log n)
// 空间复杂度：O(n)
// ======================================================

public class InversePairs {
    private long cnt = 0;

    public int inversePairs(int[] nums) {
        // write code here
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    private void merge(int[] nums, int left, int right, int mid) {
        int l1 = left, l2 = mid + 1, k = 0;
        int[] res = new int[right - left + 1];
        while (l1 <= mid && l2 <= right) {
            if (nums[l1] <= nums[l2]) {
                res[k++] = nums[l1++];
            } else {
                res[k++] = nums[l2++];
                cnt += mid - l1 + 1;
            }
        }
        while (l1 <= mid) res[k++] = nums[l1++];
        while (l2 <= right) res[k++] = nums[l2++];

        for (int i = 0; i < res.length; i++) {
            nums[left + i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        InversePairs test = new InversePairs();
        System.out.println(test.inversePairs(nums));
    }
}
