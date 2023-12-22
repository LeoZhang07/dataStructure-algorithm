package msb.rookie.binaryTree;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 二叉树的遍历
 * @date 2023/4/14 00:30
 */
public class BinaryTreeTraversal {
    StringBuffer sb = new StringBuffer();

    /**
     * 先序
     *
     * @param head
     */
    public void preTravel(TreeNode head) {
        if (head == null) {
            return;
        }
        sb.append(head.val + ';');
        preTravel(head.left);
        preTravel(head.right);
    }

    /**
     * 中序
     *
     * @param head
     */
    public void inTravel(TreeNode head) {
        if (head == null) {
            return;
        }
        inTravel(head.left);
        sb.append(head.val + ';');
        inTravel(head.right);
    }

    /**
     * 后序
     *
     * @param head
     */
    public void postTravel(TreeNode head) {
        if (head == null) {
            return;
        }
        postTravel(head.left);
        postTravel(head.right);
        sb.append(head.val + ';');
    }
}
