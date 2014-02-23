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
    public ArrayList<Integer> inorderTraversal_Recur(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            if (root.left != null) {
                result.addAll(inorderTraversal_Recur(root.left));
            }
            result.add(root.val);
            if (root.right != null) {
                result.addAll(inorderTraversal_Recur(root.right));
            }
        }

        return result;
    }

    public ArrayList<Integer> inorderTraversal_Iter(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return result;
        }

        do {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            do {
                root = stack.pop();
                result.add(root.val);
            } while (root.right == null && stack.empty() == false);

            root = root.right;
        } while (root != null);

        return result;
    }
}
