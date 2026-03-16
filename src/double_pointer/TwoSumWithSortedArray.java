package double_pointer;

import java.util.ArrayList;

// ====================== 核心思路 ======================
// 题目：递增排序数组中找到和为S的两个数字
// 解法：双指针法（利用数组递增特性）
// 1. 左指针 i 从数组头部开始，右指针 j 从数组尾部开始
// 2. 两数和 == sum → 直接返回结果
// 3. 两数和 > sum → 右指针左移，减小和
// 4. 两数和 < sum → 左指针右移，增大和

// 时间复杂度：O(n)，只遍历一次数组
// 空间复杂度：O(1)，只使用了常数变量
// ======================================================

public class TwoSumWithSortedArray {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length == 0 || sum == 0) {
            return res;
        }
        int i = 0, j = array.length - 1;

        while (i != j) {
            int cur = array[i] + array[j];
            if (cur == sum) {
                res.add(array[i]);
                res.add(array[j]);
                return res;
            } else if (cur > sum) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        int sum = 5;
        TwoSumWithSortedArray test = new TwoSumWithSortedArray();
        System.out.println(test.FindNumbersWithSum(array, sum));
    }
}
