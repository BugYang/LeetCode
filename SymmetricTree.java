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
    public boolean isSymmetric(TreeNode root) {
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
}
