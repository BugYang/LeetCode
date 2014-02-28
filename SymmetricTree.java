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
        if (root == null) {
            return true;
        }
        Stack<TreeNode> lstack = new Stack<TreeNode>(), rstack = new Stack<TreeNode>();
        lstack.push(root.left);
        rstack.push(root.right);
        while (!lstack.empty() && !rstack.empty()) {
            TreeNode lnode = lstack.pop(), rnode = rstack.pop();
            if (lnode != null && rnode != null) {
                if (lnode.val != rnode.val) {
                    return false;
                }
                lstack.push(lnode.left);
                rstack.push(rnode.right);
                rstack.push(lnode.right);
                lstack.push(rnode.left);
            } else if (lnode != rnode) {
                return false;
            }
        }
        return true;
    }
}
