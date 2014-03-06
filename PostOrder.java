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
    public ArrayList<Integer> postorderTraversal_recur(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public ArrayList<Integer> postorderTraversal_iter_2stack(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> extract = new Stack<TreeNode>();
        Stack<TreeNode> traversal = new Stack<TreeNode>();

        if (root != null) {
            extract.push(root);
        }
        while (!extract.empty()) {
            TreeNode cur = extract.pop();
            if (cur.left != null) {
                extract.push(cur.left);
            }
            if (cur.right != null) {
                extract.push(cur.right);
            }
            traversal.push(cur);
        }

        while (!traversal.empty()) {
            TreeNode cur = traversal.pop();
            result.add(cur.val);
        }
        return result;

    }

    public ArrayList<Integer> postorderTraversal_iter(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode prev = null, cur;
        if (root != null) {
            s.push(root);
        }
        while (!s.empty()) {
            cur = s.peek();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    s.push(cur.left);
                } else if (cur.right != null) {
                    s.push(cur.right);
                } else {
                    result.add(cur.val);
                    s.pop();
                }
            } else if (prev == cur.left) {
                if (cur.right != null) {
                    s.push(cur.right);
                } else {
                    result.add(cur.val);
                    s.pop();
                }
            } else if (prev == cur.right) {
                result.add(cur.val);
                s.pop();
            }
            prev = cur;
        }
        return result;
    }
}
