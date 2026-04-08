package DynamicProgramming;

public class Fibonacci {
    public int Fibonacci(int n) {
        // write code here
        if (n == 1 || n == 2) return 1;
        int prepre = 1, pre = 1, now = 0;
        for (int i = 3; i <= n; i++) {
            now = prepre + pre;
            prepre = pre;
            pre = now;
        }
        return now;
    }

    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        System.out.println(test.Fibonacci(6));
    }
}
