package tree;

// ====================== JZ33 二叉搜索树的后序遍历序列 ======================
// 核心思想：分治递归
// 1. 后序遍历最后一位是根节点
// 2. 左边所有 < 根 → 左子树
// 3. 右边所有 > 根 → 右子树
// 4. 递归判断左右子树

// 时间复杂度：O(n²) 最坏情况（单链）
// 空间复杂度：O(n) 递归栈
// =========================================================================

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if (end - start <= 1) return true;
        int root = sequence[end];
        int index = start;
        while (sequence[index] < root && index < end) index++;
        for (int i = index; i < end; i++) {
            if (sequence[i] < root) return false;
        }
        return verify(sequence, start, index - 1) && verify(sequence, index, end - 1);
    }
}
