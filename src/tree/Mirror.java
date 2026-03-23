package tree;

// ====================== 核心思路 ======================
// 题目：求二叉树的镜像（翻转二叉树）
// 解法：递归交换左右子树
// 1. 递归终止：节点为 null 直接返回
// 2. 交换当前节点的左、右孩子
// 3. 递归处理左子树、递归处理右子树
// 原理：自顶向下交换，整棵树自动变成镜像

// 时间复杂度：O(n) 每个节点访问一次
// 空间复杂度：O(n) 递归栈最坏情况
// ======================================================

public class Mirror {
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) return null;
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
