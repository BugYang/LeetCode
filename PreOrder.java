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
}
