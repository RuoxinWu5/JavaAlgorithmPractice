package DynamicProgramming;

import java.util.Arrays;

public class JumpStairsPlus {
    public int jumpFloorII(int number) {
        // write code here
        if (number == 0) return 1;
        int[] dp = new int[number + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= number; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[number];
    }

    public int jumpFloorII2(int number) {
        // write code here
        if (number == 0) return 1;
        int[] dp = new int[number + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= number; i++) {
            dp[i] = 2 * dp[i - 1];
        }
        return dp[number];
    }

    public int jumpFloorII3(int number) {
        // write code here
        if (number == 0) return 1;
        int now = 1;
        for (int i = 1; i < number; i++) {
            now = 2 * now;
        }
        return now;
    }

    public int jumpFloorII4(int number) {
        // write code here
        return (int) Math.pow(2, number - 1);
    }

    public static void main(String[] args) {
        JumpStairsPlus test = new JumpStairsPlus();
        System.out.println(test.jumpFloorII4(4));
    }
}
