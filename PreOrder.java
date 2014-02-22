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
    public ArrayList<Integer> preorderTraversal_Recur(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            result.add(root.val);
            if (root.left != null) {
                result.addAll(preorderTraversal_Recur(root.left));
            }
            if (root.right != null) {
                result.addAll(preorderTraversal_Recur(root.right));
            }
        }
        return result;
    }

    public ArrayList<Integer> preorderTraversal_Iter(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root != null) {
            stack.push(root);
        }
        while (stack.empty() == false) {
            TreeNode current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }
}
