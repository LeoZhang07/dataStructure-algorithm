package leetcode.tree;

import definitions.TreeNode;

/**
 * @author leo
 * @version 1.0
 * @description: TODO leetcode 104 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @理解：当节点为最末尾的时候，其子节点都为null，返回的是0，而+1正是其结果，递归返回的时候，每次往上一层都会+1。画个图就知道了
 * @date 2023/12/27
 * @Copyright：treadstone.JasonBourne.com
 */
public class L104_MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
