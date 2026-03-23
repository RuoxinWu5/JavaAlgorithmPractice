package tree;

// ====================== JZ36 二叉搜索树与双向链表 ======================
// 核心思想：
// 1. 二叉搜索树 【中序遍历】 == 【递增有序序列】
// 2. 用一个前驱节点 pre 记录上一个节点
// 3. 把当前节点 和 前驱节点 互相指向（构建双向链表）
// 4. 记录第一个节点作为链表头 head

// 时间复杂度：O(n)  遍历每个节点一次
// 空间复杂度：O(n)  递归栈（最坏单链）
// =====================================================================

public class Convert {
    // 用于记录前驱节点
    TreeNode pre = null;
    // 用于记录链表头节点
    TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        if (pre != null) {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
        } else {
            head = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.right);
        return head;
    }

}
