package arrays_matrices;

// ====================== 核心思路 ======================
// 题目条件：二维数组每行从左到右递增，每列从上到下递增
// 利用【右上角起点筛选法】：从矩阵最右上角开始查找
// 1. 当前值 < 目标值 → 向下移动（变大）
// 2. 当前值 > 目标值 → 向左移动（变小）
// 3. 找到相等则返回true，越界则返回false

// 时间复杂度：O(n + m), 最多遍历一行+一列，线性复杂度
// 空间复杂度：O(1), 仅使用有限变量，无额外空间开辟
// ======================================================

public class FindIn2DArray {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param target int整型
     * @param array  int整型二维数组
     * @return bool布尔型
     */
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int x = array.length;
        int y = array[0].length;
        int i = 0;
        int j = y - 1;
        while (i < x && j >= 0) {
            if (target > array[i][j]) {
                i++;
            } else if (target < array[i][j]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindIn2DArray obj = new FindIn2DArray();
        int target = 1;
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean res = obj.Find(target, array);
        System.out.println(res);
    }
}
