/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head, hare = head;
        do {
            hare = hare == null ? null : hare.next;
            hare = hare == null ? null : hare.next;
            if (hare == null) {
                return null;
            }
            tortoise = tortoise.next;
        } while (hare != tortoise);

        hare = head;
        while (hare != tortoise) {
            hare = hare.next;
            tortoise = tortoise.next;
        }

        return hare;
    }
}
