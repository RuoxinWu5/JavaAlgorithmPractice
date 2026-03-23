package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize {
    String Serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val + ",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        // 去掉最后一个逗号
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        if (str.equals("#")) return null;
        String[] arr = str.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode parent = q.poll();
            if (!arr[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.add(left);
            }
            i++;
            // 右孩子
            if (!arr[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                q.add(right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        // 构建一棵树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Serialize test = new Serialize();

        // 序列化
        String s = test.Serialize(root);
        System.out.println("序列化结果：" + s);

        // 反序列化
        TreeNode newRoot = test.Deserialize(s);
        System.out.println("反序列化完成！");
    }
}
