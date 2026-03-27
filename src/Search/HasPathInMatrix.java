package Search;

public class HasPathInMatrix {
    public boolean hasPath(String matrix, int rows, int cols, String str) {
        if (rows == 0 || cols == 0) return false;
        if (str.isEmpty()) return true;

        // 转换为矩阵
        char[] charArray = matrix.toCharArray();
        char[][] matrixArray = buildMatrix(rows, cols, charArray);

        int[][] flag = new int[rows][cols];
        char[] pathArray = str.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(matrixArray, flag, pathArray, rows, cols, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrixArray, int[][] flag, char[] pathArray, int rows, int cols, int now, int i, int j) {
        if (now == pathArray.length) return true;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrixArray[i][j] != pathArray[now] || flag[i][j] == 1)
            return false;
        flag[i][j] = 1;
        now++;
        if (dfs(matrixArray, flag, pathArray, rows, cols, now, i - 1, j)
                || dfs(matrixArray, flag, pathArray, rows, cols, now, i + 1, j)
                || dfs(matrixArray, flag, pathArray, rows, cols, now, i, j + 1)
                || dfs(matrixArray, flag, pathArray, rows, cols, now, i, j - 1))
            return true;
        flag[i][j] = 0;
        return false;
    }

    private static char[][] buildMatrix(int rows, int cols, char[] charArray) {
        char[][] matrix1 = new char[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = charArray[idx++];
            }
        }
        return matrix1;
    }

    public static void main(String[] args) {
        String matrix = "ABCESFCSADEE";
        int rows = 3;
        int cols = 4;
        String str1 = "ABCCED";
        String str2 = "ABCB";
        HasPathInMatrix test = new HasPathInMatrix();
        System.out.println(test.hasPath(matrix, rows, cols, str1));
        System.out.println(test.hasPath(matrix, rows, cols, str2));
    }

}
