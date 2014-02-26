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
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST_helper(num, 0, num.length-1);
    }

    private TreeNode sortedArrayToBST_helper(int[] num, int begin, int end) {
        if (begin >= end) {
            return begin == end ? new TreeNode(num[begin]) : null;
        }

        int div = (begin+end)/2;
        TreeNode root = new TreeNode(num[div]);
        root.left = sortedArrayToBST_helper(num, begin, div-1);
        root.right = sortedArrayToBST_helper(num, div+1, end);

        return root;
    }
}
