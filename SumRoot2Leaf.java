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
    public int sumNumbers_recur(TreeNode root) {
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

    public int sumNumbers_iter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        Queue<Integer> intQ = new LinkedList<Integer>();
        int result = 0, cnt = 1;
        nodeQ.add(root);
        intQ.add(0);

        while (cnt != 0) {
            int new_cnt = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode node = nodeQ.poll();
                int base = intQ.poll();
                if (node.left == null && node.right == null) {
                    result += base * 10 + node.val;
                }
                if (node.left != null) {
                    nodeQ.add(node.left);
                    intQ.add(base * 10 + node.val);
                    new_cnt++;
                }
                if (node.right != null) {
                    nodeQ.add(node.right);
                    intQ.add(base * 10 + node.val);
                    new_cnt++;
                }
            }
            cnt = new_cnt;
        }

        return result;
    }
}
