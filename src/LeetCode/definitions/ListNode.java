package LeetCode.definitions;

/**
 * @Author zkx
 * @ClassName ListNode
 * @Description TODO Definition for singly-linked list.
 * @Date 2022/8/29 14:31
 * Version 1.0
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
