package msb.rookie.binaryTree;

/**
 * @author leo
 * @version 1.0
 * @description: TODO
 * @date 2023/4/14 00:30
 */
public class BinaryTreeTraversal {
    StringBuffer sb = new StringBuffer();

    public void preTravel(TreeNode head) {
        if (head == null) {
            return;
        }
        sb.append(head.value + ';');
        preTravel(head.left);
        preTravel(head.right);
    }

    public void inTravel(TreeNode head) {
        if (head == null) {
            return;
        }
        inTravel(head.left);
        sb.append(head.value + ';');
        inTravel(head.right);
    }

    public void postTravel(TreeNode head) {
        if (head == null) {
            return;
        }
        postTravel(head.left);
        postTravel(head.right);
        sb.append(head.value + ';');
    }
}
