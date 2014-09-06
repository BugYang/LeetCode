/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
        public void recoverTree(TreeNode root) {
                TreeNode[] errors = new TreeNode[2], last = new TreeNode[1];
                int tmp;

                detectError(root, errors, last);
                tmp = errors[0].val;
                errors[0].val = errors[1].val;
                errors[1].val = tmp;
        }

        public void detectError(TreeNode root, TreeNode[] errors, TreeNode[] last) {
                if (root == null)
                        return;

                if (root.left != null)
                        detectError(root.left, errors, last);

                if (last[0] != null) {
                        if (errors[0] == null && last[0].val > root.val)
                                errors[0] = last[0];
                        if (errors[0] != null && last[0].val > root.val)
                                errors[1] = root;
                }
                last[0] = root;

                if (root.right != null)
                        detectError(root.right, errors, last);
                else if (errors[1] == null)
                        errors[1] = root;
        }
}
