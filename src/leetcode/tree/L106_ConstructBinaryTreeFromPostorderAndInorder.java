package leetcode.tree;

import definitions.TreeNode;

import java.util.HashMap;

/**
 * @author leo
 * @version 1.0
 * @description: TODO
 * @date 2024/1/25 16:44
 * @Copyright：treadstone.JasonBourne.com
 */
public class L106_ConstructBinaryTreeFromPostorderAndInorder {
    int postIdx;
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.inorder = inorder;
        this.postorder = postorder;
        postIdx = postorder.length - 1;
        return recursiveBuild(0,inorder.length - 1);
    }

    public TreeNode recursiveBuild(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        postIdx--;
        root.right = recursiveBuild(index + 1, inRight);
        root.left = recursiveBuild(inLeft, index - 1);
        return root;
    }
}
