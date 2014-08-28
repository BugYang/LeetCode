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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode node = head;
        for (int i = 1; i < k; i++) {
            node = node.next;
            if (node == null)
                return head;
        }

        ListNode list = reverseKGroup(node.next, k);
        
        for (int i = 0; i < k; i++) {
            node = head.next;
            head.next = list;
            list = head;
            head = node;
        }

        return list;        
    }
}