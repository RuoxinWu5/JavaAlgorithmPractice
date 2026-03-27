package DivideAndConquer;

// ====================== JZ16 数值的整数次方 ======================
// 解法：快速幂（分治思想）
// 核心：将大指数二分，递归计算子问题，减少乘法次数
// 原理：x^n = x^(n/2) * x^(n/2)  偶数
//      x^n = x^(n/2) * x^(n/2) * x  奇数

// 时间复杂度：O(log n)
// 空间复杂度：O(log n) 递归栈
// =================================================================

public class Power {
    public double power(double base, int exponent) {
        boolean isNegative = exponent < 0 ? true : false;
        if (isNegative) exponent = -exponent;
        double res = pow(base, exponent);
        return isNegative ? 1 / res : res;
    }

    // 分治 = 拆分 + 递归解决 + 合并结果
    // 分治的子问题：互相独立、互不干扰、结构相同
    private double pow(double base, int exponent) {
        // 2. 解决：最小问题直接返回
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        // 1. 拆分：把大指数拆成一半
        double res = pow(base, exponent / 2);

        // 3. 合并：把子结果拼成大结果
        res = exponent % 2 == 0 ? res * res : res * res * base;
        return res;
    }

    public static void main(String[] args) {
        Power test = new Power();
        System.out.println(test.power(2.00000, 3));
        System.out.println(test.power(2.10000, 3));

        System.out.println(test.power(2.00000, -2));
    }
}
