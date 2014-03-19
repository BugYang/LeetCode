/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null;  }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x;  }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return sortedListToBSTHelper(head, len);
    }

    public TreeNode sortedListToBSTHelper(ListNode head, int len) {
        if (len < 1 || head == null) {
            return null;
        }
        ListNode cur = head;
        int idx = len/2;
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }

        TreeNode root = new TreeNode(cur.val);
        root.left = sortedListToBSTHelper(head, idx);
        root.right = sortedListToBSTHelper(cur.next, len-idx-1);
        return root;
    }

}
