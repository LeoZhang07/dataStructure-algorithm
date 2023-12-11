package huawei;

import definitions.ListNode;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 判断链表中是否有环
 * 用 O(1)（即，常量）内存
 * @思路：快慢指针，可以快指针(fast)每次走两步，慢指针(slow)每次走一步。如果存在环的话快指针先进入环，慢指针后入环，在慢指针到达末尾前快指针会追上慢指针。
 * 快慢指针如果有相遇那就说明有环，如果快指针先为null那就说明没环。
 * @date 2023/10/29 14:59
 * @Copyright：treadstone.JasonBourne.com
 */
public class CircleSingleLinkedList {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            slow = slow.next;
            for (int i = 0; i < 2; i++) {
                if (fast != null) {
                    fast = fast.next;
                }
            }
            if ((slow == fast || slow.next == fast) && fast != null) {
                return true;
            }
        }
        return false;
    }
}
