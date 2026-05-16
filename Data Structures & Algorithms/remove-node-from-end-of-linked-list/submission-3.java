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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Nodo ficticio apuntando a head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Adelantar fast exactamente n+1 pasos
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Mover ambos hasta que fast llegue al final
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow está justo antes del nodo a eliminar
        slow.next = slow.next.next;

        return dummy.next; // head puede haber cambiado
    }
}
