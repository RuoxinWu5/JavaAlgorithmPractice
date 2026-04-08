package DynamicProgramming;

public class JumpStairs {
    public int jumpFloor(int number) {
        // write code here
        if (number <= 2) return number;
        int prepre = 1, pre = 2, now = 0;
        for (int i = 3; i <= number; i++) {
            now = prepre + pre;
            prepre = pre;
            pre = now;
        }
        return now;
    }

    public static void main(String[] args) {
        JumpStairs test = new JumpStairs();
        System.out.println(test.jumpFloor(7));
    }
}
