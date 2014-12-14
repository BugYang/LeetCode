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
	public ListNode sortList(ListNode head) {
		ListNode cur = head;
		int len = 0;
		while (cur != null) {
			len++;
			cur = cur.next;
		}

		if (len < 2) {
			return head;
		} else {
			ListNode listL = head, listR = getKthNode(head, len/2);
			return mergeSort(listL, len/2, listR, len-len/2);
		}
	}

	public ListNode getKthNode(ListNode head, int k) {
		while (k-- > 0)
			head = head.next;
		return head;
	}

	public ListNode mergeSort(ListNode listL, int lenL, ListNode listR, int lenR) {
		if (lenL > 1)
			listL = mergeSort(listL, lenL/2, getKthNode(listL, lenL/2), lenL-lenL/2);
		if (lenR > 1)
			listR = mergeSort(listR, lenR/2, getKthNode(listR, lenR/2), lenR-lenR/2);

		// merge listL and listR
		ListNode head = new ListNode(0);
		ListNode cur = head;


		while (true) {
			boolean chooseL;
			if (lenL > 0 && lenR > 0) {
				chooseL = listL.val < listR.val ? true : false;
			} else if (lenL > 0) {
				chooseL = true;
			} else if (lenR > 0) {
				chooseL = false;
			} else {
				break;
			}

			if (chooseL) {
				cur.next = listL;
				listL = listL.next;
				lenL--;
			} else {
				cur.next = listR;
				listR = listR.next;
				lenR--;
			}
			cur = cur.next;
		}
		cur.next = null;

		return head.next;
	}
}
