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
}
