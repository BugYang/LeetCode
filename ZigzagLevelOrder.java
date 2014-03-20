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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> rows = new ArrayList<ArrayList<TreeNode>>();
        ArrayList<TreeNode> lastRow = new ArrayList<TreeNode>();
        boolean evenRow = true;

        if (root == null) {
            return new ArrayList<ArrayList<Integer>>();
        }

        lastRow.add(root);
        rows.add(lastRow);
        while (true) {
            ArrayList<TreeNode> row = new ArrayList<TreeNode>();
            for (int i = lastRow.size()-1; i >= 0; i--) {
                TreeNode node = lastRow.get(i);
                if (evenRow) {
                    if (node.right != null) {
                        row.add(node.right);
                    }
                    if (node.left != null) {
                        row.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        row.add(node.left);
                    }
                    if (node.right != null) {
                        row.add(node.right);
                    }
                }
            }
            if (row.size() == 0) {
                break;
            }
            rows.add(row);
            lastRow = row;
            evenRow = !evenRow;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<TreeNode> row : rows) {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for (TreeNode node : row) {
                nums.add(node.val);
            }
            result.add(nums);
        }
        return result;
    }
}
