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
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode before = null, after = null;
		ListNode begin = null, end = null;
		ListNode node = head, next;
		int i = 0;

		while (node != null) {
			i++;
			next = node.next;

			if (i == m - 1) {
				before = node;
			} else if (m <= i && i <= n) {
				node.next = begin;
				begin = node;
				if (i == m)
					end = node;        
			} else if (i == n + 1) {
				after = node;
			}

			node = next;
		}

		if (before == null)
			head = begin;
		else
			before.next = begin;
		end.next = after;

		return head;
	}
}
