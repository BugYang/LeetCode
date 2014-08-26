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
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode node = head.next;
		ListNode next = node.next;
		head.next = null;

		while (node != null) {
			head = insertNode(head, node);
			node = next;
			if (next != null)
				next = next.next;
		}

		return head;
	}

	public ListNode insertNode(ListNode head, ListNode node) {
		if (node.val < head.val) {
			node.next = head;
			return node;
		}

		ListNode cur = head;
		while (cur.next != null && cur.next != node && cur.next.val < node.val)
			cur = cur.next;
		node.next = cur.next;
		cur.next = node;
		return head;
	}
}
