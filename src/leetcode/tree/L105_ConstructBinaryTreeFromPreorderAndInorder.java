package leetcode.tree;

import definitions.TreeNode;

import java.util.HashMap;

/**
 * @author leo
 * @version 1.0
 * @description: 从前序与中序遍历序列构造二叉树
 * preorder 和 inorder 均 无重复 元素
 * @date 2024/1/9 17:04
 * @Copyright：treadstone.JasonBourne.com
 */
public class L105_ConstructBinaryTreeFromPreorderAndInorder {
    HashMap<Integer, Integer> map;
    int[] preO;
    int[] inO;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        this.preO = preorder;
        this.inO = inorder;
        return recursionBuild(0, length - 1, 0, length - 1);
    }

    /**
     * @param preLeft  前序数组，子树的最左端
     * @param preRight 前序数组，子树的最右端
     * @param inLeft   中序数组，子树的最左端
     * @param inRight  中序数组，子树的最右端
     * @return
     */
    public TreeNode recursionBuild(int preLeft, int preRight, int inLeft, int inRight) {
        //说明子树的长度已经为0了
        if (preLeft > preRight) {
            return null;
        }
        //根在前序中的位置：就是preLeft
        TreeNode root = new TreeNode(preO[preLeft]);
        //根在中序中的位置
        Integer rootInorderPosition = map.get(root.val);
        //左子树的长度
        int lengthOfLeft = rootInorderPosition - inLeft;
        //右子树的长度
        int lengthOfRight = inRight - rootInorderPosition;
        //填入左子树的 前序左、前序右、中序左、中序右
        root.left = recursionBuild(preLeft + 1, preLeft + lengthOfLeft, inLeft, rootInorderPosition - 1);
        //填入右子树的 前序左、前序右、中序左、中序右
        root.right = recursionBuild(preLeft + lengthOfLeft + 1, preLeft + lengthOfLeft + lengthOfRight, rootInorderPosition + 1, rootInorderPosition + lengthOfRight);
        return root;
    }


}

//class Solution {
//    int[] pre, in;
//    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        this.pre = preorder;
//        this.in = inorder;
//        this.inMap = inMap;
//        for (int i = 0; i < inorder.length; i++) {
//            inMap.put(inorder[i], i);
//        }
//        return constructBST(0, 0, pre.length);
//    }
//
//    public TreeNode constructBST(int preIndex, int postIndex, int length) {
//        if (length <= 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(pre[preIndex]);
//        if (length == 1) {
//            return root;
//        }
//        int k = inMap.get(root.val);
//        int l = k - postIndex;
//        root.left = constructBST(preIndex + 1, postIndex, l);
//        root.right = constructBST(preIndex + l + 1, k + 1, length - l - 1);
//        return root;
//    }
//
//}
