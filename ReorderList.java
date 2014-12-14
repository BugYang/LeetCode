/**
 * Definition for singly-linked list.
 * class ListNode {
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

	public ListNode reverseList(ListNode head) {
		ListNode reverse = null, tmp;
		while (head != null) {
			tmp = head;
			head = head.next;
			tmp.next = reverse;
			reverse = tmp;
		}
		return reverse;
	}

	public void reorderList(ListNode head) {
		int len = getListLen(head);
		if (len < 2)
			return;
		int lenL = len - len/2, lenR = len/2;

		// break from middle
		ListNode listL = head, listR, cur = getKthNode(head, lenL-1);
		listR = cur.next;
		cur.next = null;

		// reverse listR
		listR = reverseList(listR);

		// merge
		head = listL;
		listL = listL.next;
		cur = head;
		while (true) {
			if (listR != null) {
				cur.next = listR;
				cur = cur.next;
				listR = listR.next;
			}
			if (listL != null) {
				cur.next = listL;
				cur = cur.next;
				listL = listL.next;
			}
			if (listL == null && listR == null)
				break;
		}
		cur.next = null;
	}
}
