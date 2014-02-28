/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x;  }
 * }
 *         */
public class Solution {
    public boolean isSymmetric_recur(TreeNode root) {
        return root == null ? true : cmpNode(root.left, root.right);
    }

    public boolean cmpNode(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        } else {
            return node1.val == node2.val 
                && cmpNode(node1.left, node2.right) && cmpNode(node1.right, node2.left);
        }
    }

    public boolean isSymmetric_iter(TreeNode root) {
        Stack<TreeNode> lstack = new Stack<TreeNode>(), rstack = new Stack<TreeNode>();
        if (root && root.left) {
            lstack.push(root.left);
        }
        if (root && root.right) {
            rstack.push(root.right);
        }
        while (lstack.size() == rstack.size()) {
            if (lstack.empty() && rstack.empty()) {
                return true;
            }
            TreeNode lnode = lstack.pop(), rnode = rstack.pop();
            if (lnode.val != rnode.val) {
                return false;
            }
            if (lnode.left) {
                lstack.push(lnode.left);
            }
            if (rnode.right) {
                rstack.push(rnode.right);
            }
            if (lnode.right) {
                rstack.push(lnode.right);
            }
            if (rnode.left) {
                lstack.push(rnode.left);
            }
        }
        return false;
    }
}
