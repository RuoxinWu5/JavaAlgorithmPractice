package tree;

// ====================== 核心思路 ======================
// 题目：二叉树的下一个结点（中序遍历的下一个节点）
// 解法：分两种情况直接查找（最优解，无需遍历整棵树）
// 1. 如果当前节点有右子树 → 下一个节点是右子树的【最左节点】
// 2. 如果当前节点无右子树 → 向上找父节点，直到当前节点是【父节点的左孩子】
// 3. 若一直找到根节点都不满足 → 无下一个节点，返回null
// 原理：直接利用中序遍历规则 + 父指针快速定位

// 时间复杂度：O(n) 最坏情况遍历树高度
// 空间复杂度：O(1) 仅用临时变量，无额外空间
// ======================================================

public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode node = pNode.next;
                if (pNode == node.left)
                    return node;
                pNode = pNode.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        /*
               8
             /   \
            6     10
           / \   / \
          5  7  9  11
          中序：5,6,7,8,9,10,11
         */

        // 构建节点
        TreeLinkNode n8 = new TreeLinkNode(8);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n10 = new TreeLinkNode(10);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n9 = new TreeLinkNode(9);
        TreeLinkNode n11 = new TreeLinkNode(11);

        // 左右孩子
        n8.left = n6;
        n8.right = n10;
        n6.left = n5;
        n6.right = n7;
        n10.left = n9;
        n10.right = n11;

        // 父指针 next
        n6.next = n8;
        n10.next = n8;
        n5.next = n6;
        n7.next = n6;
        n9.next = n10;
        n11.next = n10;

        GetNext test = new GetNext();

        // 测试1：输入8 → 输出9
        TreeLinkNode next1 = test.GetNext(n8);
        System.out.println("节点8的下一个节点：" + (next1 == null ? "null" : next1.val));

        // 测试2：输入6 → 输出7
        TreeLinkNode next2 = test.GetNext(n6);
        System.out.println("节点6的下一个节点：" + (next2 == null ? "null" : next2.val));

        // 测试3：输入7 → 输出8
        TreeLinkNode next3 = test.GetNext(n7);
        System.out.println("节点7的下一个节点：" + (next3 == null ? "null" : next3.val));

        // 测试4：输入11 → 输出null
        TreeLinkNode next4 = test.GetNext(n11);
        System.out.println("节点11的下一个节点：" + (next4 == null ? "null" : next4.val));
    }
}
