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
    public void flatten_preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode cur, last = null;
        while (!stack.empty()) {
            cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

            cur.left = null;
            if (last != null) {
                last.right = cur;
            }
            last = cur;
        }
    }

    public void flatten_nonpreorder(TreeNode root) {
        if (root != null) {
            root = flattenHelper(root);
        }
    }

    public TreeNode flattenHelper(TreeNode root) {
        if (root.right != null) {
            root.right = flattenHelper(root.right);
            public void flatten(TreeNode root) {
                if (root != null) {
                    root = flattenHelper(root);
                }
            }

            public TreeNode flattenHelper(TreeNode root) {
                if (root.right != null) {
                    root.right = flattenHelper(root.right);
                }
                if (root.left != null) {
                    root.left = flattenHelper(root.left);
                    TreeNode leftTail = root.left;
                    while (leftTail.right != null) {
                        leftTail = leftTail.right;
                    }
                    leftTail.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
                return root;
            }
        }
    }
}

