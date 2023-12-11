package leetcode.LinkedList;

import definitions.ListNode;

/**
 * @author leo
 * @version 1.0
 * @description: TODO leetcode 21. 合并两个有序链表
 * @date 2023/11/16 22:18
 * @Copyright：treadstone.JasonBourne.com
 */
public class Q21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode hair = new ListNode();
        ListNode temp = hair;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return hair.next;
    }
}
