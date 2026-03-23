package tree;

// ====================== JZ55 求二叉树的深度 ======================
// 核心思想：递归
// 树的深度 = 1（当前节点） + 左子树深度与右子树深度的较大值
// 空节点深度为 0

// 时间复杂度：O(n) 每个节点遍历一次
// 空间复杂度：O(n) 递归调用栈（最坏情况）
// =================================================================

public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
        return depth;
    }
    public static void main(String[] args) {
        /*
           测试用树结构：
               1
             /   \
            2     3
           / \     \
          4   5     6
               \
                7
           最长路径：1 → 2 → 5 → 7
           深度 = 4
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        TreeDepth test = new TreeDepth();
        int depth = test.TreeDepth(root);
        System.out.println("二叉树深度为：" + depth); // 输出 4
    }
}
