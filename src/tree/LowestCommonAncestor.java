package tree;

public class LowestCommonAncestor {
    // 二叉查找树(该结点的值介于二者之间)
    public TreeNode lowestCommonAncestorInBinarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestorInBinarySearchTree(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestorInBinarySearchTree(root.right, p, q);
        return root;
    }

    // 普通二叉树(p、q分布在该节点的左右子树)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null && right == null) return null;
        if (left == null) return right;
        return left;
    }
}
