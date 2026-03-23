package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// ====================== JZ32 从上往下打印二叉树 ======================
// 题目：不分行从上往下打印二叉树（层序遍历 / BFS）
// 规则：同层从左到右，空节点不打印
// 核心数据结构：队列 Queue

// 时间复杂度：O(n)，遍历所有节点
// 空间复杂度：O(n)，队列最多存储一层节点，最坏情况（全二叉树最后一层）为 O(n)
// ==================================================================

public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
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
           预期输出：[8,6,10,2,1]
         */
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(1);

        PrintFromTopToBottom test = new PrintFromTopToBottom();
        ArrayList<Integer> result = test.PrintFromTopToBottom(root);
        System.out.println(result);  // 输出 [8, 6, 10, 2, 1]
    }
}
