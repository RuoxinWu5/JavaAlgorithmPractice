package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// ====================== JZ78 把二叉树打印成多行 ======================
// 解法：双队列交替 BFS（非常清晰的写法）
// 思路：
// 1. queue 存放当前层节点
// 2. queue2 存放下一层节点
// 3. 遍历当前层，收集值到一行，同时把子节点放入下一层队列
// 4. 一层结束后，queue = queue2，开始下一层

// 时间复杂度：O(n) —— 每个节点仅入队、出队一次
// 空间复杂度：O(n) —— 队列存储节点
// ==================================================================

public class Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            ArrayList<Integer> res1 = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                res1.add(node.val);
                if (node.left != null) queue2.add(node.left);
                if (node.right != null) queue2.add(node.right);
            }
            queue = queue2;
            res.add(res1);
        }
        return res;
    }

    public static void main(String[] args) {
        /*
           测试树结构：
               8
             /   \
            6    10
                /  \
               2    1
           预期输出：[[8], [6, 10], [2, 1]]
         */
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(1);

        Print test = new Print();
        ArrayList<ArrayList<Integer>> result = test.Print(root);
        System.out.println(result);
    }
}
