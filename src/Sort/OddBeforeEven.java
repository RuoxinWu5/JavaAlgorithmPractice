package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddBeforeEven {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        OddBeforeEven test = new OddBeforeEven();
        System.out.println(Arrays.toString(test.reOrderArray(nums)));
    }

    public int[] reOrderArray(int[] array) {
        // write code here
        int oddNumber = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 1) oddNumber++;
        }
        int[] res = new int[n];
        for (int i = 0, j = oddNumber, k = 0; k < n; k++) {
            if (array[k] % 2 == 1) res[i++] = array[k];
            else res[j++] = array[k];
        }
        return res;
    }

}
