package tree;

// ====================== JZ79 判断平衡二叉树 ======================
// 最优写法：后序遍历 + 剪枝
// 思路：
// 1. 从底向上计算左右子树高度
// 2. 一旦发现高度差 >1，立刻标记不平衡，直接剪枝（不再递归）
// 3. 最后返回标记结果
// 优点：只遍历一次节点，效率远高于顶部计算高度

// 时间复杂度：O(n)   每个节点只遍历一次
// 空间复杂度：O(n)   递归栈最坏情况（单链）
// =================================================================

public class IsBalanced {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode pRoot) {
        // write code here
        TreeDepth(pRoot);
        return isBalanced;
    }

    private int TreeDepth(TreeNode root) {
        if (root == null || !isBalanced)
            return 0;
        int a = TreeDepth(root.left);
        int b = TreeDepth(root.right);
        if (Math.abs(a - b) > 1)
            isBalanced = false;
        int depth = 1 + Math.max(a, b);
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
        // 平衡二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        IsBalanced test = new IsBalanced();
        System.out.println(test.IsBalanced_Solution(root)); // true
    }
}
