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
    public int getListLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }   
        return len;
    }   

    public ListNode getKthNode(ListNode head, int k) {
        while (k-- > 0)
            head = head.next;
        return head;
    }   

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return head;
        int len = getListLen(head);
        n %= len;
        if (n == 0)
            return head;
        ListNode listLTail = getKthNode(head, len-n-1);
        ListNode listR = listLTail.next;
        listLTail.next = null;
        ListNode listRTail = getKthNode(listR, n-1);
        listRTail.next = head;
        return listR;
    }
}