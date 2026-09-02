package leetcode;

import leetcode.utill.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (n == 1 && head.next == null)) {
            return null;
        }
        int i = processRemove(head, n);
        if (i == n) {
            return head.next;
        }
        return head;
    }

    private int processRemove(ListNode curNode, int toRemove) {
        if (curNode.next == null) {
            return 1;
        } else {
            int fromEndIndex = processRemove(curNode.next, toRemove);
            if (fromEndIndex == toRemove) {
                ListNode next = curNode.next.next;
                if (next != null) {
                    curNode.next = next;
                } else {
                    curNode.next = null;
                }
            }
            return fromEndIndex + 1;
        }
    }
}
