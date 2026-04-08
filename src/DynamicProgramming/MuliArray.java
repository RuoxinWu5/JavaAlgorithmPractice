package DynamicProgramming;

import java.util.Arrays;

public class MuliArray {
    public static int[] multiply(int[] A) {
        // write code here
        int n = A.length;
        int[] B = new int[n];
        Arrays.fill(B, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            B[i] = res;
            res *= A[i];
        }
        res = 1;
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= res;
            res *= A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = new int[]{100, 50};
        System.out.println(Arrays.toString(multiply(A)));
    }
}
