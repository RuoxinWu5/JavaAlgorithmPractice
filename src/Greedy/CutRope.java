package Greedy;

public class CutRope {
    // ===================== 解法1：贪心算法 =====================
    // 核心思想：根据数学规律，尽可能多切长度为 3 的段，乘积最大
    // 余数为 1 时，把 3+1 改为 2+2（乘积更大）
    // 余数为 2 时，直接保留 2
    // 余数为 0 时，全为 3

    // 时间复杂度：O(1) —— 仅做简单数学运算
    // 空间复杂度：O(1) —— 未使用额外空间
    // ==========================================================
    public int cutRope1(int n) {
        // write code here
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int l = n % 3;
        if (l == 1) return (int) (Math.pow(3, n / 3 - 1) * 4);
        else if (l == 2) return (int) (Math.pow(3, n / 3) * 2);
        else return (int) Math.pow(3, n / 3);
    }

    // ===================== 解法2：动态规划 =====================
    // 核心思想：
    // dp[i] = 长度为 i 的绳子剪切后的最大乘积
    // 对每个 i，枚举切分点 j：
    // 乘积 = j * max( 剩下的继续剪, 剩下的不剪 )

    // 时间复杂度：O(n²) —— 两层循环
    // 空间复杂度：O(n) —— 使用了 dp 数组
    // ==========================================================
    public int cutRope(int n) {
        // write code here
        int[] maxRes = new int[n + 1];
        maxRes[2] = 1;
        maxRes[3] = 2;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                maxRes[i] = Math.max(maxRes[i], j * Math.max(maxRes[i - j], (i - j)));// 剪下来的j * 剩下长度max(剪, 不剪)
            }
        }
        return maxRes[n];
    }

    public static void main(String[] args) {
        CutRope test = new CutRope();
        System.out.println(test.cutRope(8));
        System.out.println(test.cutRope(15));
    }
}
