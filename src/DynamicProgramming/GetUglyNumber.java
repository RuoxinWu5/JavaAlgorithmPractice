package DynamicProgramming;

public class GetUglyNumber {
    public static int GetUglyNumber_Solution(int index) {
        // write code here
        if (index <= 0) return 0;
        int[] dp = new int[index];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {
            int next = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            dp[i] = next;
            if (next == dp[p2] * 2) p2++;
            if (next == dp[p3] * 3) p3++;
            if (next == dp[p5] * 5) p5++;
        }
        return dp[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(7));
    }

}
