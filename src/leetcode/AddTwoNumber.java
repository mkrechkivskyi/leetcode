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
 *
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 */
public class AddTwoNumber {

    public static void main(String[] args) {
        //[2,4,3]
        //l2 =
        //[5,6,4]
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
////        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

//        ListNode l1 = new ListNode(5, new ListNode(6));
//        ListNode l2 = new ListNode(5, new ListNode(4, new ListNode(9)));

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(1)));
        ListNode l2 = new ListNode(1);

//        ListNode l1 = new ListNode(1, new ListNode(8));
//        ListNode l2 = new ListNode(0);
        ListNode listNode = new AddTwoNumber().addTwoNumbers(l1, l2);
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isOutBound = false;
        int i = l1.val + l2.val;
        if (i >= 10) {
            isOutBound = true;
            i = i % 10;
        }
        ListNode resHead = new ListNode(i);
        processNodeCalculation(l1.next, l2.next, resHead, isOutBound);
        return resHead;
    }

    public ListNode processNodeCalculation(ListNode l1, ListNode l2, ListNode resNode, boolean isOutBound) {
        if (l1 == null && l2 == null) {
            if (isOutBound) {
                resNode.next = new ListNode(1);
                return resNode;
            } else {
                return null;
            }
        }
        if (l1 == null) {
            if (isOutBound) {
                int i = l2.val + 1;
                ListNode listNode = new ListNode(i);
                resNode.next = listNode;
                if (i >= 10) {
                    listNode.val = i %10;
                    processNodeCalculation(l2.next, null, listNode, true);
                } else {
                    processNodeCalculation(l2.next, null, listNode, false);
                }
                return resNode;
            } else {
                ListNode listNode = new ListNode(l2.val);
                resNode.next =  listNode;
                processNodeCalculation(l2.next, null, listNode, false);
                return resNode;
            }
        }
        if (l2 == null) {
            if (isOutBound) {
                int i = l1.val + 1;
                ListNode listNode = new ListNode(i);
                resNode.next = listNode;
                if (i >= 10) {
                    listNode.val = i %10;
                    processNodeCalculation(l1.next, null, listNode, true);
                } else {
                    processNodeCalculation(l1.next, null, listNode, false);
                }
                return resNode;
            } else {
                ListNode listNode = new ListNode(l1.val);
                resNode.next =  listNode;
                processNodeCalculation(l1.next, null, listNode, false);
                return resNode;
            }
        }
        int i = isOutBound ? l1.val + l2.val + 1 : l1.val + l2.val;
        if (i >= 10) {
            i = i % 10;
            isOutBound = true;
        } else {
            isOutBound = false;
        }
        ListNode newNext = new ListNode(i);
        resNode.next = newNext;
        return processNodeCalculation(l1.next, l2.next, newNext, isOutBound);
    }

}
