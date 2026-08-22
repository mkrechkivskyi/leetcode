package leetcode;

import leetcode.utill.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 21. Merge Two Sorted Lists
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode = new MergeTwoSortedLists().mergeTwoLists(listNode1, listNode2);
        System.out.println();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode begin;
        if (list1.val <= list2.val) {
            begin = new ListNode(list1.val);
            processMergeTwoSortedLists(list1.next, list2, begin);
        } else {
            begin = new ListNode(list2.val);
            processMergeTwoSortedLists(list1, list2.next, begin);

        }
        return begin;
    }

    void processMergeTwoSortedLists(ListNode l1, ListNode l2, ListNode res) {
        if (l1 == null && l2 == null) {
            return;
        }
        if (l1 == null) {
            res.next = new ListNode(l2.val);
            processMergeTwoSortedLists(null, l2.next, res.next);
            return;

        }
        if (l2 == null) {
            res.next = new ListNode(l1.val);
            processMergeTwoSortedLists(null, l1.next, res.next);
            return;
        }
        if (l1.val <= l2.val) {
            res.next = new ListNode(l1.val);
            processMergeTwoSortedLists(l1.next, l2, res.next);
            return;
        } else {
            res.next = new ListNode(l2.val);
            processMergeTwoSortedLists(l1, l2.next, res.next);
            return;
        }
    }
}

