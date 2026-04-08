package DynamicProgramming;

public class MaxSumofContinSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        // write code here
        int pre = array[0];
        int max = pre;
        for (int i = 1; i < array.length; i++) {
            int now = Math.max(array[i], pre + array[i]);
            max = Math.max(now, max);
            pre = now;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSumofContinSubArray test = new MaxSumofContinSubArray();
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(test.FindGreatestSumOfSubArray(array));
    }
}
