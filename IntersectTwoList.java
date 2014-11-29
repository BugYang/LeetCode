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
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		int lenA = getListLen(headA);
		int lenB = getListLen(headB);
		ListNode curA = headA;
		ListNode curB = headB;

		// align
		while (lenA != lenB) {
			if (lenA > lenB) {
				curA = curA.next;
				lenA--;
			} else {
				curB = curB.next;
				lenB--;
			}
		}

		// search
		while (curA != null) {
			if (curA == curB)
				return curA;
			curA = curA.next;
			curB = curB.next;
		}

		return null;
	}

	public int getListLen(ListNode head) {
		// assume head not null
		int len = 1;
		while ((head = head.next) != null)
			len++;
		return len;
	}
}
