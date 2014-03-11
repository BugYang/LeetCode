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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbersHelper(root, 0);
    }

    public int sumNumbersHelper(TreeNode root, int base) {
        base = base * 10 + root.val;
        int result = 0;
        if (root.left != null) {
            result += sumNumbersHelper(root.left, base);
        }
        if (root.right != null) {
            result += sumNumbersHelper(root.right, base);
        }
        return result == 0 ? base : result;
    }
}/**
  * Definition for binary tree
  *  * public class TreeNode {
  *   *     int val;
  *    *     TreeNode left;
  *     *     TreeNode right;
  *      *     TreeNode(int x) { val = x;  }
  *       * }
  *        */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbersHelper(root, 0);
    }

    public int sumNumbersHelper(TreeNode root, int base) {
        base = base * 10 + root.val;
        int result = 0;
        if (root.left != null) {
            result += sumNumbersHelper(root.left, base);
        }
        if (root.right != null) {
            result += sumNumbersHelper(root.right, base);
        }
        return result == 0 ? base : result;
    }
}
