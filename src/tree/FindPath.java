package tree;

import java.util.ArrayList;

public class FindPath {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        // write code here
        backtracking(root, target, new ArrayList<>()); // 开始走
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path)); // 找到一条！
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        /*
        构造测试树：
             10
            /  \
           5    12
          / \
         4   7

        target = 22
        预期结果：[[10,5,7],[10,12]]
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        FindPath test = new FindPath();
        ArrayList<ArrayList<Integer>> result = test.FindPath(root, 22);

        System.out.println("最终结果：");
        System.out.println(result);
    }
}
