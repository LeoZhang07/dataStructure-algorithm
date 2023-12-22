package leetcode;

import definitions.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author leo
 * @version 1.0
 * @description: TODO 合并K个排序链表
 * @date 2023/12/13 15:52
 * @Copyright：treadstone.JasonBourne.com
 */
public class MergeKLists {
    //堆实现（优先级队列）
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        //把所有的头节点放入小根堆
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }
        ListNode hair = new ListNode(0);
        ListNode tail = hair;
        while (!priorityQueue.isEmpty()) {
            ListNode polledNode = priorityQueue.poll();
            tail.next = polledNode;
            tail = tail.next;
            if (polledNode.next != null) {
                priorityQueue.add(polledNode.next);
            }
        }
        return hair.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode[] arr = {l1, l2};
        ListNode mergedList = mergeKLists1(arr);
        while (mergedList != null) {
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }

    }
}
