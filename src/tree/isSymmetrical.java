package tree;

// ====================== 核心思路 ======================
// 题目：判断二叉树是否对称（是否是自身的镜像）
// 解法：递归双指针法
// 1. 根节点不动，判断左子树、右子树是否对称
// 2. 对称规则：
//    - 左节点的左孩子 = 右节点的右孩子
//    - 左节点的右孩子 = 右节点的左孩子
// 3. 两个节点同时为空则对称，一个空一个不空则不对称

// 时间复杂度：O(n) 遍历每个节点一次
// 空间复杂度：O(n) 递归栈
// ======================================================

public class isSymmetrical {
    public boolean isSymmetrical(TreeNode pRoot) {
        // write code here
        if (pRoot == null) return true;
        return isSymm(pRoot.left, pRoot.right);
    }

    private boolean isSymm(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymm(left.left, right.right) && isSymm(left.right, right.left);
    }
}
