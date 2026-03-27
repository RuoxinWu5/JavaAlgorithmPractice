package Search;

import java.util.ArrayList;
import java.util.Arrays;

public class PermuteString {
    private final ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        // write code here
        if (str.isEmpty()) return new ArrayList<>();

        char[] charArray = str.toCharArray();
        Arrays.sort(charArray); // ⭐ 必须排序！

        char[] array = new char[str.length()];
        int[] flag = new int[str.length()];

        dfs(0, charArray, array, flag);
        return res;
    }

    private void dfs(int i, char[] charArray, char[] array, int[] flag) {
        if (i == array.length) {
            res.add(new String(array));
            return;
        }
        for (int j = 0; j < charArray.length; j++) {
            if (j > 0 && charArray[j] == charArray[j - 1] && flag[j - 1] == 0)
                continue;
            if (flag[j] == 0) {
                array[i] = charArray[j];
                flag[j] = 1;
                dfs(i + 1, charArray, array, flag);
                flag[j] = 0;
            }
        }

    }

    public static void main(String[] args) {
        PermuteString test = new PermuteString();
        System.out.println(test.Permutation("aba"));
    }
}
