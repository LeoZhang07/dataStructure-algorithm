import definitions.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ForCodingTest {
    public static void main(String[] args) {

        Queue<TreeNode> queue = new LinkedList<>();
        System.out.println(queue.offer(null));
        System.out.println(queue);
    }
}
