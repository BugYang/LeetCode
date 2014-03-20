/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null;  }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        return generateTreesHelper(nums, 0, n-1);
    }

    public ArrayList<TreeNode> generateTreesHelper(int[] nums, int begin, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();

        if (begin > end) {
            result.add(null);
            return result;
        }
        for (int i = begin; i <= end; i++) {
            ArrayList<TreeNode> lefts = generateTreesHelper(nums, begin, i-1);
            ArrayList<TreeNode> rights = generateTreesHelper(nums, i+1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(nums[i]);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
