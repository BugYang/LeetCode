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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> nodes = new ArrayList<ArrayList<TreeNode>>();
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>(), last;
        if (root != null) {
            cur.add(root);
        }

        while (cur.size() != 0) {
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
        for (ArrayList<TreeNode> list : nodes) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (TreeNode node : list) {
                tmp.add(node.val);
            }
            result.add(tmp);
        }
        return result;
    }
}
