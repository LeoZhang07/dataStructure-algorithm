package LeetCode.LinkedList;

import LeetCode.definitions.ListNode;

/**
 * @Author zkx
 * @ClassName MergeTwoLists
 * @Description TODO 21. 合并两个有序链表 easy
 * @Date 2022/11/10 11:05
 * Version 1.0
 **/
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                 temp.next = list1;
                 list1 = list1.next;
                 temp = temp.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        temp.next = list1 == null ? list2 : list1;
        return dummyHead.next;
    }
}
