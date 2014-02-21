/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *      *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle_HashSet(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle_Floyd(ListNode head) {
        ListNode tortoise = head, hare = head;
        do {
            hare = hare == null ? null : hare.next;
            hare = hare == null ? null : hare.next;
            if (hare == null) {
                return false;
            }
            tortoise = tortoise.next;

        } while (tortoise != hare);
        return true;
    }

}
