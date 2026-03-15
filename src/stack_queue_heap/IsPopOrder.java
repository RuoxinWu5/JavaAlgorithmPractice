package stack_queue_heap;

import java.util.Stack;

// ====================== 核心思路 ======================
// 题目：判断第二个序列是否是第一个序列的合法弹出顺序
// 解法：用一个栈模拟压入和弹出操作
// 1. 按入栈顺序，逐个将元素压入辅助栈
// 2. 每压入一个元素，就检查栈顶是否等于当前待弹出的元素
// 3. 如果相等，就弹出栈顶，并将待弹出指针后移一位，继续检查
// 4. 当所有元素都压入后，如果辅助栈为空，说明是合法弹出序列

// 时间复杂度：O(n)，每个元素入栈、出栈各一次
// 空间复杂度：O(n)，需要一个辅助栈存储元素
// ======================================================

public class IsPopOrder {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pushV int整型一维数组
     * @param popV  int整型一维数组
     * @return bool布尔型
     */
    public boolean IsPopOrder(int[] pushV, int[] popV) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int length = pushV.length;
        for (int pushIndex = 0, popIndex = 0; pushIndex < length; pushIndex++) {
            stack.push(pushV[pushIndex]);
            while (!stack.isEmpty() && stack.peek() == popV[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsPopOrder test = new IsPopOrder();
        int[] pushV = new int[]{1, 2, 3, 4, 5};
        int[] popV = new int[]{4, 3, 5, 2, 1};
        System.out.println(test.IsPopOrder(pushV, popV));
    }
}
