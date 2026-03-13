package arrays_matrices;

// ====================== 核心思路 ======================
// 题目条件：长度为n，数字都在 0 ~ n-1 之间
// 利用【原地交换法】：把每个数字放到它值对应的下标位置
// 即：数字 k 应该放在下标 k 的位置
// 如果要放的位置已经是 k，说明 k 重复

// 时间复杂度：O(n), 整体是线性遍历
// 空间复杂度：O(1), 只使用了常数级额外空间，没有开辟新数组/集合，在原数组上操作
// ======================================================

public class FindDuplicateNumber {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate(int[] numbers) {
        // write code here
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        for (int i = 0; i < numbers.length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                } else {
                    swap(i, numbers[i], numbers);
                }
            }
        }
        return -1;
    }

    private void swap(int number1, int number2, int[] numbers) {
        int temp = numbers[number1];
        numbers[number1] = numbers[number2];
        numbers[number2] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 1, 3, 2};
        FindDuplicateNumber obj = new FindDuplicateNumber();
        int res = obj.duplicate(numbers);
        System.out.println(res);
    }
}
