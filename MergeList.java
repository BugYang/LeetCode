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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, cur = null, tmp, cur1, cur2;
        while (l1 != null || l2 != null) {
            cur1 = l1 != null ? l1 : l2;
            cur2 = l2 != null ? l2 : l1;
            tmp = cur1.val < cur2.val ? cur1 : cur2;

            if (head == null) {
                cur = head = tmp;
            } else {
                cur = cur.next = tmp;
            }

            l1 = tmp == l1 ? l1.next : l1;
            l2 = tmp == l2 ? l2.next : l2;
        }
        return head;
    }
} 
