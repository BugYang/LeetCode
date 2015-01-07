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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        
        ListNode head = new ListNode(0);
        ListNode cur = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return Integer.compare(a.val, b.val);
            }
        });
        
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        
        while (pq.size() != 0) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        
        return head.next;
    }
}