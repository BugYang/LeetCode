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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                ArrayList<Integer> path = new ArrayList<Integer>();
                path.add(root.val);
                paths.add(path);
            }
        } else {
            if (root.left != null) {
                paths.addAll(pathSum(root.left, sum-root.val));
            }
            if (root.right != null) {
                paths.addAll(pathSum(root.right, sum-root.val));
            }
            for (ArrayList<Integer> path : paths) {
                path.add(0, root.val);
            }
        }

        return paths;
    }
}
