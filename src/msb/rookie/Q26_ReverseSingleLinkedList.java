package msb.rookie;

import definitions.ListNode;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 单链表的翻转
 * @date 2023/10/27 16:11
 * @Copyright：treadstone.JasonBourne.com
 */
public class Q26_ReverseSingleLinkedList {
    public ListNode reverseSingleLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
