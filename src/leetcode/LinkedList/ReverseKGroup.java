package leetcode.LinkedList;

import definitions.ListNode;
import org.junit.Test;


/**
 * @Author zkx
 * @ClassName ReverseKGroup
 * @Description TODO 25.K个一组翻转链表
 * <p>
 * ***************************************
 * 值传递与引用传递
 * java中只有值传递，可以根据地址更改对应地址中的内容，
 * 但是传递过来的参数本质上是一块新的内存区域指向了对应的内存，因此修改形参的地址，并不能更改原本的地址内容
 * @Date 2022/9/2 9:43
 * Version 1.0
 **/
public class ReverseKGroup {
    @Test
    public void testReverse() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * main
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        /** init && prepare */
        if (k < 2) {
            return head;
        }
        ListNode hair = new ListNode(0, head);
        ListNode groupHair = hair;
        ListNode groupHead = head;
        ListNode groupTail = null;
        /** begin */
        while (groupHead != null) {
            groupTail = getTail(groupHead, k);
            if (groupTail == null) {
                return hair.next;
            }
            ListNode[] reverse = reverse(groupHead, groupTail);
            //第一次执行的时候会直接将hair.next给设置为翻转之后的groupHead
            groupHair.next = reverse[0];
            groupHair = reverse[1];
            groupHead = reverse[1].next;
        }
        return hair.next;
    }

    /**
     * @return：tail||null
     */
    public ListNode getTail(ListNode head, int k) {
        ListNode tail = head;
        while (--k > 0) {
            tail = tail.next;
            if (tail == null) {
                return null;
            }
        }
        return tail;
    }

    /**
     * 1. 组内逆序
     * 2. 将逆序后的尾节点链上下一组的头节点
     * 3. 返回翻转后的头节点和尾节点
     */
    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode front = tail.next;
        ListNode mid = head;
        ListNode rare = null;
        while (front != tail) {
            //逆向需要把next指针重新赋值，必须要记录一下原先的next位置在哪，不然找不到下一个节点
            rare = mid.next;
            //逆向
            mid.next = front;
            //指针转移
            front = mid;
            mid = rare;
        }
        return new ListNode[]{tail, head};
    }
}
