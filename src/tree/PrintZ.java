package tree;

import java.util.*;

public class PrintZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean reverse = false;
        while (!queue.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            ArrayList<Integer> res1 = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                res1.add(node.val);
                if (node.left != null) queue2.add(node.left);
                if (node.right != null) queue2.add(node.right);
            }
            queue = queue2;
            if (reverse) Collections.reverse(res1);
            res.add(res1);
            reverse = !reverse;
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
           预期输出：[[8], [6, 10], [2, 1]]
         */
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(1);

        PrintZ test = new PrintZ();
        ArrayList<ArrayList<Integer>> result = test.Print(root);
        System.out.println(result);
    }
}
