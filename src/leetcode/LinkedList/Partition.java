package leetcode.LinkedList;

import definitions.ListNode;

/**
 * @Author zkx
 * @ClassName Partition
 * @Description TODO 86. 分隔链表
 * @Date 2022/8/29 14:30
 * Version 1.0
 **/
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode current = head;
        ListNode smallTail = new ListNode();
        ListNode smallHead = smallTail;
        ListNode largeTail = new ListNode();
        ListNode largeHead = largeTail;

        while (current != null){
            if (current.val < x){
                smallTail.next = current;
                smallTail = smallTail.next;
                current = current.next;
            }else {
                largeTail.next = current;
                largeTail = largeTail.next;
                current = current.next;
            }
        }
        //截断，防止成为环形链表
        largeTail.next = null;
        smallTail.next = largeHead.next;
        return smallHead.next;
    }
}
