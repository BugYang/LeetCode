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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> nodes = new ArrayList<ArrayList<TreeNode>>();
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>(), last;

        if (root != null) {
            cur.add(root);
        }
        while (!cur.isEmpty()) {
            nodes.add(cur);
            last = cur;
            cur = new ArrayList<TreeNode>();
            for (TreeNode node : last) {
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = nodes.size()-1; i >= 0; i--) {
            ArrayList<Integer> vals = new ArrayList<Integer>();
            for (TreeNode node : nodes.get(i)) {
                vals.add(node.val);
            }
            result.add(vals);
        }
        return result;
    }
}
