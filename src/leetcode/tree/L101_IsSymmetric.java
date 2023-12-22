package leetcode.tree;

import msb.rookie.binaryTree.TreeNode;
import org.junit.Test;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 101. 对称二叉树 检查二叉树是否轴对称
 * @note：根节点下，左根节点的左子树=右根节点的右子树；左根节点的右子树=右根节点的左子树
 * @date 2023/12/20 16:25
 * @Copyright：treadstone.JasonBourne.com
 */
public class L101_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }

    @Test
    public void test() {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), null));
        isSymmetric(tree);
    }
}
