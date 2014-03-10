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
    public ListNode removeNthFromEnd_2pass(ListNode head, int n) {
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        cur = head;
        if (len > n) {
            while (len > n+1) {
                cur = cur.next;
                len--;
            }
            cur.next = cur.next.next;
        } else {
            head = head.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd_1pass(ListNode head, int n) {
        ListNode last = null, cur = head;
        while (true) {
            ListNode tmp = cur;
            for (int i = 0; i < n; i++) {
                tmp = tmp.next;
            }
            if (tmp == null) {
                break;
            }
            last = cur;
            cur = cur.next;
        }

        if (last == null) {
            head = head.next;
        } else {
            last.next = cur.next;
        }
        return head;
    }
}
