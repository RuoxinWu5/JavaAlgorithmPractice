package DynamicProgramming;

public class RectangleCover {
    public int rectCover(int target) {
        if (target == 0 || target == 1 || target == 2) return target;
        int prepre = 1, pre = 2;
        int now = 0;
        for (int i = 3; i <= target; i++) {
            now = prepre + pre;
            prepre = pre;
            pre = now;
        }
        return now;
    }

    public static void main(String[] args) {
        RectangleCover test = new RectangleCover();
        System.out.println(test.rectCover(4));
    }
}
