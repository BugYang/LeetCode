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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 0, rightDepth = 0;
        if (root.left != null) {
            leftDepth = maxDepth(root.left);
        }
        if (root.right != null) {
            rightDepth = maxDepth(root.right);
        }

        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}
