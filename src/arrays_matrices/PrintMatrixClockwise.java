package arrays_matrices;

import java.util.ArrayList;

// ====================== 核心思路 ======================
// 题目要求：顺时针从外向内打印矩阵
// 利用【边界圈印法】：设定上下左右四个边界，按圈遍历
// 1. 左 → 右：打印最上面一行
// 2. 上 → 下：打印最右边一列
// 3. 右 → 左：打印最下面一行（防止单行重复）
// 4. 下 → 上：打印最左边一列（防止单列重复）
// 每打印完一圈，边界向内收缩，直到边界越界结束

// 时间复杂度：O(m*n)，每个元素只遍历一次
// 空间复杂度：O(1)，除结果集外仅使用常数变量
// ======================================================

public class PrintMatrixClockwise {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int j = c1; j <= c2; j++) {
                res.add(matrix[r1][j]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                res.add(matrix[i][c2]);
            }
            if (r1 != r2)
                for (int j = c2 - 1; j >= c1; j--) {
                    res.add(matrix[r2][j]);
                }
            if (c1 != c2)
                for (int i = r2 - 1; i >= r1 + 1; i--) {
                    res.add(matrix[i][c1]);
                }
            c1++;
            c2--;
            r1++;
            r2--;
        }

        return res;
    }

    public static void main(String[] args) {
        PrintMatrixClockwise test = new PrintMatrixClockwise();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        //int[][] matrix = {{1,2,3,4}};
        ArrayList<Integer> res = test.printMatrix(matrix);
        System.out.println(res);
    }
}
