package LeetCode.LinkedList;

import LeetCode.definitions.ListNode;
import org.junit.Test;


/**
 * @Author zkx
 * @ClassName ReverseKGroup
 * @Description TODO 25.K个一组翻转链表
 *
 * ***************************************
 *                  值传递与引用传递
 *                  java中只有值传递，可以根据地址更改对应地址中的内容，
 *                  但是传递过来的参数本质上是一块新的内存区域指向了对应的内存，因此修改形参的地址，并不能更改原本的地址内容
 * @Date 2022/9/2 9:43
 * Version 1.0
 **/
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getGroupEnd(start, k);
        if (end == null || k < 2) {
            return head;
        }
        reverse(start, end);
        head = end;

        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public ListNode getGroupEnd(ListNode start, int k) {
        while (start != null && --k != 0) {
            start = start.next;
        }
        return start;
    }

    public void reverse(ListNode start, ListNode end) {
        ListNode nextHead = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next;
        while (cur != nextHead) {
            next = cur.next;
            cur.next = pre;//reverse
            pre = cur;
            cur = next;
        }
        start.next = nextHead;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ListNode node = reverseKGroup(head, 2);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

}
