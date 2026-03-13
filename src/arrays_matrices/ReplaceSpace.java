package arrays_matrices;

// ====================== 核心思路 ======================
// 题目要求：将字符串中的空格替换成 "%20"
// 利用 String 自带的 replace 方法，直接替换所有空格
// 或者遍历字符串，遇到空格拼接 %20

// 时间复杂度：O(n)，需要遍历一次字符串
// 空间复杂度：O(n)，创建新字符串存储结果
// ======================================================

public class ReplaceSpace {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace(String s) {
        // write code here
        if (s == null || s.isEmpty()) {
            return s;
        }
        //String 不可变，少量操作
        //StringBuilder 可变，单线程最快
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace obj = new ReplaceSpace();
        String res = obj.replaceSpace("We Are Happy");
        System.out.println(res); // 输出：We%20Are%20Happy
    }
}
