package leetcode.tree;

import definitions.TreeNode;

import java.util.HashMap;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 106. 从中序与后序遍历序列构造二叉树
 * @date 2024/1/25 11:19
 * @Copyright：treadstone.JasonBourne.com
 */
public class L106_ConstructBinaryTreeFromPostorderrAndInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {

        }
        return recursiveBuild(0, inorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode recursiveBuild(int postLeft, int postRight, int inLeft, int inRight) {
        TreeNode root = new TreeNode(postRight);
        root.right = null;
        return null;
    }
}
