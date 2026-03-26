package Greedy;

// ====================== 121. 买卖股票的最佳时机 ======================
// 核心思想：贪心算法
// 1. 记录遍历到当前位置的最小价格
// 2. 每天计算：当天价格 - 历史最低价 = 利润
// 3. 保存最大利润

// 时间复杂度：O(n)   只遍历一次数组
// 空间复杂度：O(1)   只使用了常数级变量
// ====================================================================

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        MaxProfit test = new MaxProfit();
        System.out.println(test.maxProfit(prices));
    }
}
