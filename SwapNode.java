/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            int t = cur.next.val;
            cur.next.val = cur.val;
            cur.val = t;
            cur = cur.next.next;
        }
        return head;
    }
}
