/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        ListNode currentL1 = list1;
        ListNode currentL2 = list2;

        while (currentL1 != null && currentL2 != null) {
            if (currentL1.val <= currentL2.val) {
                tail.next = currentL1;
                currentL1 = currentL1.next;
            } else {
                tail.next = currentL2;
                currentL2 = currentL2.next;
            }
            tail = tail.next;
        }

        if (currentL1 != null) {
            tail.next = currentL1;
        } else {
            tail.next = currentL2;
        }

        return dummy.next;
    }
}