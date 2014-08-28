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
    public ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicatesHelper(head);
    }
    
    public ListNode deleteDuplicatesHelper(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        if (head.next.val == head.val) {
            ListNode node = head.next;
            while (node != null && node.val == head.val)
                node = node.next;
            return deleteDuplicatesHelper(node);
        } else {
            head.next = deleteDuplicatesHelper(head.next);
            return head;
        }
    }
}