package leetcode.LinkedList;

import definitions.ListNode;

/**
 * @Author zkx
 * @ClassName AddTwoNumbers
 * @Description TODO leetcode 2.两数相加
 * @Date 2022/9/2 10:22
 * Version 1.0
 **/
public class L2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode();
        ListNode tail = hair;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            tail.next = new ListNode(sum % 10, null);
            tail = tail.next;
            carry = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry,null);
        }
        return hair.next;
    }


    //time:O(n) space:O(n)
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode curr = newHead;
        int a;
        int b;
        int carry = 0;
        while (l1 != null || l2 != null) {
            a = l1 == null ? 0 : l1.val;
            b = l2 == null ? 0 : l2.val;
            curr.next = new ListNode((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return newHead.next;
    }

    //time:O(n) space:O(1)
    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        return null;
    }

    public int listLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
