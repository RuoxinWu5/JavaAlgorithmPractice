package DynamicProgramming;

public class GiftWithMaxValue {
    public int getMost(int[][] board) {
        // write code here
        int m = board.length, n = board[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]) + board[i][j];
            }
        }
        return dp[m][n];
    }

    public int getMost1(int[][] board) {
        // write code here
        int m = board.length, n = board[0].length;
        // 我们每一行计算时，其实只需要：上一行、当前行（正在更新）
        // 那就意味着❗根本不需要整个二维数组 ==> 存一维数组
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            dp[0] += board[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + board[i][j];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        GiftWithMaxValue solution = new GiftWithMaxValue();

        // 测试用例1：标准3x3矩阵
        int[][] board1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("测试用例1结果：" + solution.getMost1(board1)); // 预期输出：12

        // 测试用例2：单行矩阵
        int[][] board2 = {{1, 2, 3, 4}};
        System.out.println("测试用例2结果：" + solution.getMost1(board2)); // 预期输出：10

        // 测试用例3：单列矩阵
        int[][] board3 = {{1}, {2}, {3}};
        System.out.println("测试用例3结果：" + solution.getMost1(board3)); // 预期输出：6
    }
}
