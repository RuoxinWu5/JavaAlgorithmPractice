package Search;

public class CountReachableGrids {
    private int res = 0;

    public int movingCount(int threshold, int rows, int cols) {
        if (rows == 0 || cols == 0) return 0;
        if (threshold == 0) return 1;

        int[][] matrix = new int[rows][cols];
        dfs(matrix, threshold, rows, cols, 0, 0);
        return res;
    }

    private void dfs(int[][] matrix, int threshold, int rows, int cols, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[i][j] == 1) return;
        matrix[i][j] = 1;
        if (i / 10 + i % 10 + j / 10 + j % 10 > threshold) return;
        res++;
        dfs(matrix, threshold, rows, cols, i - 1, j);
        dfs(matrix, threshold, rows, cols, i + 1, j);
        dfs(matrix, threshold, rows, cols, i, j + 1);
        dfs(matrix, threshold, rows, cols, i, j - 1);
    }

    public static void main(String[] args) {
        CountReachableGrids test = new CountReachableGrids();
        System.out.println(test.movingCount(10, 1, 100));
    }
}
