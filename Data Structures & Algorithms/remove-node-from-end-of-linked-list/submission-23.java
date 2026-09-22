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
        // consider that first node may be removed, will need to consider a dummy
        ListNode dummy = new ListNode(0, head);
        ListNode l = dummy;
        ListNode r = head;

        // constraints:
        // at least 1 node
        while (n != 0) {
            r = r.next;
            n--;
        }
        while (r != null) {
            l = l.next;
            r = r.next;
        }
        if (l != null && l.next != null) {
            l.next = l.next.next;
        }
        return dummy.next;
    }
}
