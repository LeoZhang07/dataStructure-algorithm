package leetcode.tree;

import definitions.TreeNode;

import java.util.*;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 自底向上层序遍历
 * @date 2024/3/1 11:42
 * @Copyright：treadstone.JasonBourne.com
 */
public class L107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(level);
        }
        Collections.reverse(ans);
        return ans;
    }
}
