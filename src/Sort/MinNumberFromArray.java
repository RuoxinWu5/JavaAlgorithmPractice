package Sort;

import java.util.Arrays;

// ====================== 核心思路 ======================
// 贪心思想：自定义排序
//
// 对于两个数字 x 和 y：不比较 x 和 y 本身大小，而是比较 x+y 和 y+x
// 如果 x+y < y+x，那么 x 应该排在 y 前面
//
// 举例：3 和 32
// 比较："332" 和 "323"，因为"323" 更小，所以 32 应该排在 3 前面
//
// 时间复杂度：O(nlogn)
// 空间复杂度：O(n)
// ======================================================

public class MinNumberFromArray {
    public String PrintMinNumber(int[] numbers) {
        // write code here
        if (numbers == null || numbers.length == 0) return "";
        String[] numberString = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberString[i] = numbers[i] + "";
        }
        Arrays.sort(numberString, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (String s : numberString) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinNumberFromArray test = new MinNumberFromArray();
        int[] numbers = new int[]{3, 32, 321};
        System.out.println(test.PrintMinNumber(numbers));
    }
}
