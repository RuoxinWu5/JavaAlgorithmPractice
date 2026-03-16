package double_pointer;

// ====================== 核心思路 ======================
// 题目：翻转单词序列
// 要求：输入 "nowcoder. a am I" → 输出 "I am a nowcoder."
// 解法：两次翻转法（最优解，原地翻转）
// 1. 先翻转每个单词内部字符
// 2. 再翻转整个字符串，得到单词逆序、单词本身正序的结果

// 时间复杂度：O(n)
// 空间复杂度：O(1) 原地修改
// ======================================================

public class ReverseWordsInSentence {
    public String ReverseSentence(String str) {
        if (str.isEmpty()) return "";
        char[] chars = str.toCharArray();
        int i = 0;
        int n = str.length();
        //先翻转每个单词
        for (int j = 0; j < n; j++) {
            if (j == n - 1) {
                // 最后一个单词
                reverse(chars, i, j);
            } else if (chars[j] == ' ') {
                // 遇到空格，翻转前面一个单词
                reverse(chars, i, j - 1);
                i = j + 1;
            }
        }
        //再翻转整个字符串
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String str = "nowcoder. a am I";
        ReverseWordsInSentence test = new ReverseWordsInSentence();
        System.out.println(test.ReverseSentence(str));
    }
}
