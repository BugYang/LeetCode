/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x;  }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        if (root != null) {
            queue.add(root);
        }
        while (queue.peek() != null) {
            TreeLinkNode node = queue.poll();
            connectNode(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public void connectNode(TreeLinkNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }

        TreeLinkNode cur = root, next = null;
        while (true) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
            if (cur.left != null) {
                next = cur.left;
                break;
            }
            if (cur.right != null) {
                next = cur.right;
                break;
            }
        }

        if (root.right == null) {
            root.left.next = next;
        } else {
            root.right.next = next;
            if (root.left != null) {
                root.left.next = root.right;
            }
        }
    }
}
