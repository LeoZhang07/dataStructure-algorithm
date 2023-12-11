package msb.rookie;

import definitions.ListNode;
import org.junit.Test;

/**
 * @author leo
 * @version 1.0
 * @description: TODO K 个一组翻转链表
 * @思路：按照以下步骤来： todo 1.把组内进行逆序
 * 2.上一组下个节点指向逆序后的头节点
 * 3.记录逆序后的最后一个为新的尾节点
 * @date 2023/10/27 16:27
 * @Copyright：treadstone.JasonBourne.com
 */
public class Q31_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0, head);
        ListNode preTail = hair;
        ListNode tail = preTail;
        while (head != null) {
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            groupReverse(head, tail);
            preTail.next = tail;
            //reset pointers
            preTail = head;
            head = head.next;
            tail = preTail;
        }
        return hair.next;
    }

    public void groupReverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        reverseKGroup(listNode,2);
    }

}
