package double_pointer;

// ====================== 核心思路 ======================
// 题目：左旋转字符串（循环左移n位）
// 解法：三次翻转法（原地修改，最优解）
// 1. 先翻转前 n 个字符
// 2. 再翻转后面剩下的字符
// 3. 最后翻转整个字符串，得到左移结果
// 处理：n 可能大于字符串长度，用 n % len 取模

// 时间复杂度：O(n)
// 空间复杂度：O(1) 原地操作
// ======================================================

public class LeftRotateString {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @param n   int整型
     * @return string字符串
     */
    public String LeftRotateString(String str, int n) {
        // write code here
        if (str.isEmpty()) return "";
        n = n % str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }

    public static void main(String[] args) {
        String str = "abcXYZdef";
        int n = 3;
        LeftRotateString test = new LeftRotateString();
        System.out.println(test.LeftRotateString(str, n));
    }
}
