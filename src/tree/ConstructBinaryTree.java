package tree;

import java.util.HashMap;
import java.util.Map;

// ====================== 核心思路 ======================
// 题目：根据前序遍历 + 中序遍历重建二叉树
// 解法：递归分治 + 哈希表加速查找
// 1. 前序遍历第一个节点一定是根节点
// 2. 在中序遍历中找到根节点位置，左边是左子树，右边是右子树
// 3. 用哈希表提前存储中序序列值与下标，查找根节点位置从 O(n) → O(1)
// 4. 递归构建左、右子树，拼接返回根节点
// 原理：分治法，把大树拆成小树，递归解决

// 时间复杂度：O(n) 哈希表建表O(n)，递归每个节点仅访问一次
// 空间复杂度：O(n) 哈希表存储n个节点，递归栈最坏O(n)
// ======================================================

public class ConstructBinaryTree {
    private final Map<Integer, Integer> indexForVinOrder = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
        // write code here
        if (vinOrder == null || vinOrder.length == 0) return null;
        for (int i = 0; i < vinOrder.length; i++) {
            indexForVinOrder.put(vinOrder[i], i);
        }
        return getTreeNode(preOrder, 0, preOrder.length - 1, vinOrder, 0, vinOrder.length - 1);
    }

    private TreeNode getTreeNode(int[] preOrder, int preL, int preR, int[] vinOrder, int vinL, int vinR) {
        if (preL > preR || vinL > vinR) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preL]);
        int index = indexForVinOrder.get(root.val);
        root.left = getTreeNode(preOrder, preL + 1, preL + index - vinL, vinOrder, vinL, index - 1);
        root.right = getTreeNode(preOrder, preL + index - vinL + 1, preR, vinOrder, index + 1, vinR);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTree test = new ConstructBinaryTree();

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] vin = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode root = test.reConstructBinaryTree(pre, vin);
        System.out.println("重建二叉树完成，根节点值：" + root.val);
    }
}
