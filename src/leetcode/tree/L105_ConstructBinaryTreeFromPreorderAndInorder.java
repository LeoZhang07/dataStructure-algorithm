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
    int preIdx;
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;
        preIdx = 0;
        return recursionBuild(0, inorder.length - 1);
    }

    public TreeNode recursionBuild(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preIdx];
        int index = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        preIdx++;
        root.left = recursionBuild(inLeft, index - 1);
        root.right = recursionBuild(index + 1, inRight);
        return root;
    }


//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        map = new HashMap<>();
//        int length = inorder.length;
//        for (int i = 0; i < length; i++) {
//            map.put(inorder[i], i);
//        }
//        this.preO = preorder;
//        this.inO = inorder;
//        return recursionBuild(0, length - 1, 0, length - 1);
//    }
//
//    /**
//     * @param preLeft  前序数组，子树的最左端
//     * @param preRight 前序数组，子树的最右端
//     * @param inLeft   中序数组，子树的最左端
//     * @param inRight  中序数组，子树的最右端
//     * @return
//     */
//    public TreeNode recursionBuild(int preLeft, int preRight, int inLeft, int inRight) {
//        //说明子树的长度已经为0了
//        if (preLeft > preRight) {
//            return null;
//        }
//        //根在前序中的位置：就是preLeft
//        TreeNode root = new TreeNode(preO[preLeft]);
//        //根在中序中的位置
//        Integer rootInorderPosition = map.get(root.val);
//        //左子树的长度
//        int lengthOfLeft = rootInorderPosition - inLeft;
//        //右子树的长度
//        int lengthOfRight = inRight - rootInorderPosition;
//        //填入左子树的 前序左、前序右、中序左、中序右
//        root.left = recursionBuild(preLeft + 1, preLeft + lengthOfLeft, inLeft, rootInorderPosition - 1);
//        //填入右子树的 前序左、前序右、中序左、中序右
//        root.right = recursionBuild(preLeft + lengthOfLeft + 1, preLeft + lengthOfLeft + lengthOfRight, rootInorderPosition + 1, rootInorderPosition + lengthOfRight);
//        return root;
//    }


}
