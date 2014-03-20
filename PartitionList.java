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
    public ListNode partition(ListNode head, int x) {
        ListNode result = null;
        ListNode curOrigin = head, curResult = result;
        while (curOrigin != null) {
            if (curOrigin.val < x) {
                if (result == null) {
                    result = new ListNode(curOrigin.val);
                    curResult = result;
                } else {
                    curResult.next = new ListNode(curOrigin.val);
                    curResult = curResult.next;
                }
            }
            curOrigin = curOrigin.next;
        }
        curOrigin = head;
        while (curOrigin != null) {
            if (curOrigin.val >= x) {
                if (result == null) {
                    result = new ListNode(curOrigin.val);
                    curResult = result;
                } else {
                    curResult.next = new ListNode(curOrigin.val);
                    curResult = curResult.next;
                }
            }
            curOrigin = curOrigin.next;
        }
        return result;
    }
}
