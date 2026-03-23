package tree;

import java.util.LinkedList;
import java.util.Queue;

public class HasSubtree {
    // ====================== 核心思路 ======================
    // 题目：判断二叉树B是不是二叉树A的子结构
    // 解法：递归分治
    // 1. 递归遍历A的每个节点
    // 2. 如果当前节点 == B的根节点，则递归判断结构是否完全匹配
    // 3. 只要有一个位置匹配成功，就返回true
    // 约定：空树不是任何树的子结构

    // 时间复杂度：O(m*n)
    // 空间复杂度：O(m) 递归栈
    // ======================================================
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return isSubtree(root1, root2) || isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);

    }

    // ====================== 核心思路 ======================
    // 题目：判断二叉树B是不是二叉树A的子结构
    // 解法：BFS遍历A + 双队列逐层匹配B
    // 1. 层序遍历A找和B根相同的节点
    // 2. 同步层序对比A和B的结构
    // 3. B匹配完则返回true，否则false
    // 约定：空树不是任意树的子结构

    // 时间复杂度：O(m*n)
    // 空间复杂度：O(m)
    // ======================================================

    public boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == root2.val)
                if (isSubtree2(node, root2))
                    return true;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }

    private boolean isSubtree2(TreeNode node, TreeNode root2) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(node);
        queue2.add(root2);
        while (!queue2.isEmpty()) {
            if (queue1.isEmpty()) return false;
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) return false;
            if (node2.left != null) {
                queue2.add(node2.left);
                if (node1.left != null) queue1.add(node1.left);
                else return false;
            }
            if (node2.right != null) {
                queue2.add(node2.right);
                if (node1.right != null) queue1.add(node1.right);
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
         树A：
             8
           /   \
          8     7
         / \
        9   2
             \
              7
         树B：
            8
           / \
          9   2
         结果：true
         */

        // 构建A
        TreeNode A = new TreeNode(8);
        A.left = new TreeNode(8);
        A.right = new TreeNode(7);
        A.left.left = new TreeNode(9);
        A.left.right = new TreeNode(2);
        A.left.right.right = new TreeNode(7);

        // 构建B
        TreeNode B = new TreeNode(8);
        B.left = new TreeNode(9);
        B.right = new TreeNode(2);

        HasSubtree test = new HasSubtree();
        System.out.println(test.HasSubtree(A, B)); // true
    }
}
