package leetcode.tree;

import msb.rookie.binaryTree.TreeNode;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 100. 相同的树
 * @Note：只要有不同的节点就返回，遍历到底之后，都为null，则返回true，只有把所有null节点遍历完，返回的都是true，那么这两棵树相同
 * @date 2023/12/20 13:13
 * @Copyright：treadstone.JasonBourne.com
 */
public class L100_IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //都为null，返回true
        if (p == null && q == null) {
            return true;
        }
        //只有一个为null，另外一个不为null
        else if (p == null || q == null) {
            return false;
        }
        //两个都不会为null
        else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
