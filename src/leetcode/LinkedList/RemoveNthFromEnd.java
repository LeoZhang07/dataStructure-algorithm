package leetcode.LinkedList;

import definitions.ListNode;
import org.junit.Test;

/**
 * @Author zkx
 * @ClassName RemoveNthFromEnd
 * @Description TODO 19. 删除链表的倒数第 N 个结点
 * @Date 2022/9/19 14:42
 * Version 1.0
 **/
public class RemoveNthFromEnd {
    /**
     * todo 双指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode left = dummyHead;
        ListNode right = head;
        for (int i = 0; i < n - 1; i++) {
            if (right != null) {
                right = right.next;
            }
        }
        if (right == null) {
            return null;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        ListNode ans = dummyHead.next;
        return ans;
//        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        System.out.println(removeNthFromEnd(head, 1));
    }
}
