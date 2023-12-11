package leetcode.LinkedList;

import definitions.ListNode;

/**
 * @Author zkx
 * @ClassName InsertionSortList
 * @Description TODO 147. 对链表进行插入排序
 * @Date 2022/8/30 14:52
 * Version 1.0
 **/
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE, new ListNode(head.val, null));
        ListNode curr = newHead;
        ListNode temp;
        while (head.next != null) {
            while (curr.next != null) {
                if (curr.val < head.next.val && head.next.val < curr.next.val) {
                    //插入新链表中间位置
                    temp = head.next;
                    head.next = temp.next;
                    temp.next = curr.next;
                    curr.next = temp;
                    curr = newHead;
                    break;
                }
                curr = curr.next;
            }
            if (curr.next == null) {
                //插入新链表尾
                temp = head.next;
                head.next = temp.next;
                temp.next = null;
                curr.next = temp;
                curr = newHead;
            }
        }
        return newHead.next;
    }

}
