package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 电话键盘数字 → 字母 的映射表
    // 下标 0、1 没有字母，所以是空字符串
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 主方法：输入数字字符串，返回所有字母组合
     * 例如输入 "23" → ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    public List<String> letterCombinations(String digits) {
        // 获取数字字符串长度
        int n = digits.length();

        // 边界条件：如果没有输入数字，直接返回空列表
        if (n == 0) {
            return List.of();
        }

        // 用来存放最终答案的列表
        List<String> ans = new ArrayList<>();

        // 核心：path 数组，用来记录当前正在拼接的字母组合
        // 长度 = 数字长度，因为每个数字对应一个字母
        char[] path = new char[n];

        // 开始递归：从第 0 个数字开始遍历
        dfs(0, ans, path, digits.toCharArray());

        // 返回所有组合
        return ans;
    }

    /**
     * 深度优先搜索（递归核心）
     * @param i      当前正在处理第几个数字（从 0 开始）
     * @param ans    最终答案集合
     * @param path   记录当前拼接的字母
     * @param digits 输入的数字字符数组
     */
    private void dfs(int i, List<String> ans, char[] path, char[] digits) {
        // 递归终止条件：已经处理完所有数字
        if (i == digits.length) {
            // 把 path 数组转成字符串，加入答案列表
            ans.add(new String(path));
            return;
        }

        // 1. 拿到当前数字对应的所有字母
        // digits[i] - '0' 把字符转成数字，例如 '2' → 2
        String letters = MAPPING[digits[i] - '0'];

        // 2. 遍历当前数字的每一个字母
        for (char c : letters.toCharArray()) {
            // 把当前字母放到 path 的第 i 位
            path[i] = c;

            // 3. 递归处理下一个数字
            dfs(i + 1, ans, path, digits);

            // 这里不用回溯！因为 path[i] 会被下一轮循环直接覆盖
        }
    }
}