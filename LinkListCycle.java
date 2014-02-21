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
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return true;
            }
        }
        return false;
    }

}
