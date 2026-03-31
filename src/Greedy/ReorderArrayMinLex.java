package Greedy;

// ====================== 核心思路 ======================
// 题目：重排数组，使拼接字符串字典序最小
//
// 给定：
// 字符串 s（长度 n）
// 数组 a（长度 n）
//
// 构造：
// t = s1 重复 a'[1] 次 + s2 重复 a'[2] 次 + ... + sn 重复 a'[n] 次
//
// 目标：
// 通过重排 a，最小化 t 的字典序
//
// ------------------------------------------------------
// ✅ 贪心核心：
// 字典序比较本质是“谁先出现小字符，谁更优”
//
// → 小字符（如 'a'）应该尽可能多出现
// → 大字符（如 'z'）应该尽可能少出现
//
// 👉 策略：
// 1. 按 s[i] 升序排序索引（小字符优先）
// 2. 将数组 a 按降序排序（大值优先）
// 3. 大的 a 分配给小的字符
//
// ------------------------------------------------------
// 🧠 本质：排序不等式 / 贪心匹配
//
// 如果 s[i] < s[j]
// 那么必须让 a'[i] >= a'[j]
// 否则会让大字符出现更多 → 字典序变大 ❌
//
// ------------------------------------------------------
// 时间复杂度：O(n log n)
// 空间复杂度：O(n)
// ======================================================

import java.util.*;

public class ReorderArrayMinLex {

    /**
     * 返回重排后的数组
     *
     * @param s 字符串
     * @param a 原数组
     * @return 重排后的数组
     */
    public int[] solve(String s, int[] a) {
        int n = s.length();

        // 1. 构造索引数组
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        // 2. 按字符排序（升序）
        Arrays.sort(idx, (i, j) -> {
            if (s.charAt(i) != s.charAt(j)) {
                return s.charAt(i) - s.charAt(j);
            }
            return i - j;
        });

        // 3. a 降序排序
        Arrays.sort(a);
        reverse(a);

        // 4. 贪心分配
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[idx[i]] = a[i];
        }

        return res;
    }

    // ====================== 工具函数 ======================

    // 反转数组（实现降序）
    private void reverse(int[] a) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    // ====================== 测试 ======================

    public static void main(String[] args) {
        ReorderArrayMinLex test = new ReorderArrayMinLex();

        String s = "bac";
        int[] a = {1, 2, 3};

        int[] res = test.solve(s, a);

        System.out.println(Arrays.toString(res));
        // 可能输出：[2, 3, 1]
    }
}