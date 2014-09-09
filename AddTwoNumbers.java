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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode node = result;
        int accumu = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0)+ accumu;
            node.next = new ListNode(sum % 10);
            node = node.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            accumu = sum / 10;
        }
        
        if (accumu != 0)
            node.next = new ListNode(accumu);
        
        return result.next;
    }
}
