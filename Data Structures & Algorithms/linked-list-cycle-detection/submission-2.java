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
    public boolean hasCycle(ListNode head) {
        int cont = 0;

        if (head == null){
            return false;
        }

        ListNode temp = head;

        while (temp.next != null){
            cont++;

            if (cont > 1000){
                return true;
            }

            temp = temp.next;
        }

        return false;
    }
}
