package LeetCode.LinkedList;

import LeetCode.definitions.ListNode;

/**
 * @Author zkx
 * @ClassName SwapPairs
 * @Description TODO
 * @Date 2022/9/5 15:48
 * Version 1.0
 **/
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode front;
        ListNode middle;
        ListNode rare;
        if (head == null || head.next == null) {
            return head;
        }
        front = dummyHead;
        middle = head;
        rare = head.next;
        while (rare != null && middle != null) {
            middle.next = rare.next;
            rare.next = middle;
            front.next = rare;

            front = middle;
            middle = middle.next;
            if (middle == null) {
                rare = null;
            } else {
                rare = middle.next;
            }
        }
        return dummyHead.next;
    }
}
