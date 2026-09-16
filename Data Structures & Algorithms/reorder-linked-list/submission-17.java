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
    public void reorderList(ListNode head) {
        // use fast & point to bisect, but the cutpoint if odd must be floor(n/2)
        // BC we need to nullify the end of the first half of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // truncate end of first half
        ListNode l2 = slow.next;
        slow.next = null;
        // reverse the 2nd list
        ListNode prev = null;
        while (l2 != null) {
            ListNode next = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = next;
        }
        //merge lists - l1 will have 0 or 1 more nodes than l2
        ListNode l1 = head;
        l2 = prev;
        while (l2 != null) {
            ListNode l1next = l1.next;
            l1.next = l2;
            ListNode l2next = l2.next;
            l2.next = l1next;
            l1 = l1next;
            l2 = l2next;
        }

    }
}
