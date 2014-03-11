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
    public int minDepth_recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public int minDepth_iter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 1, cnt = 1;
        queue.add(root);
        while (true) {
            int new_cnt = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    new_cnt++;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    new_cnt++;
                    queue.add(node.right);
                }
            }
            level++;
            cnt = new_cnt;
        }
    }
}
