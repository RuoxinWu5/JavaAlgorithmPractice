package double_pointer;

import java.util.ArrayList;

// ====================== 核心思路 ======================
// 题目：找出所有和为 sum 的连续正数序列（至少两个数）
// 解法：滑动窗口（双指针）法，利用连续序列的有序特性
// 1. 左指针 i、右指针 j 构成窗口，cur 表示窗口内数字和
// 2. cur < sum：右指针右移，扩大窗口，累加数字
// 3. cur > sum：左指针右移，缩小窗口，减去左边数字
// 4. cur == sum：记录序列，然后窗口整体右移继续寻找
// 5. 窗口右边界最大到 sum/2+1 即可，超过不可能形成序列

// 时间复杂度：O(n)，两个指针最多遍历 sum/2 次
// 空间复杂度：O(1)，除结果集外只用常数变量
// ======================================================

public class ContinuousSequenceSum {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param sum int整型
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum == 0) return res;
        int i = 1, j = 2;
        int cur = 3;
        while (j <= sum / 2 + 1) {
            if (cur < sum) {
                j++;
                cur += j;
            } else if (cur > sum) {
                cur -= i;
                i++;
            } else {
                ArrayList<Integer> curRes = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    curRes.add(k);
                }
                res.add(curRes);
                cur -= i;
                i++;
                j++;
                cur += j;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        ContinuousSequenceSum test = new ContinuousSequenceSum();
        System.out.println(test.FindContinuousSequence(9));
    }
}
