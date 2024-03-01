package leetcode.tree;

import definitions.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 102. 二叉树的层序遍历
 * 优化的广度优先搜索
 * @date 2024/2/29 09:24
 * @Copyright：treadstone.JasonBourne.com
 */
public class L102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    @Test
    public void test() {
        //[3,9,20,null,null,15,7]
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(levelOrder(treeNode));
    }
}
