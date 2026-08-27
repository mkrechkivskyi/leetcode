package leetcode;

import leetcode.utill.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode swappedHead = head;
        if (head == null) {
            return null;
        }
        if (head.next != null) {
            ListNode toSwapNext = head.next.next;
            swappedHead = head.next;
            swappedHead.next = head;
            head.next = toSwapNext;
            swap(head);
        }
        return swappedHead;
    }

    public void swap(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode toSwapNext = null;
            ListNode first = head.next;
            ListNode second = head.next.next;
            toSwapNext = second.next;
            head.next = second;
            second.next = first;
            first.next = toSwapNext;
            swap(first);
        }
    }
}
