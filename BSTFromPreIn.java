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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        
        ArrayList<Integer> preorder_list = new ArrayList<Integer>();
        for (int i = 0; i < preorder.length; i++)
            preorder_list.add(preorder[i]);
        return buildTreeHelper(preorder_list, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTreeHelper(ArrayList<Integer> preorder, int[] inorder, int in_i, int in_j) {
        int root_val, root_idx;
        TreeNode root;
        
        root_val = preorder.get(0);
        preorder.remove(0);
        root = new TreeNode(root_val);
        for (root_idx = in_i; root_idx <= in_j; root_idx++)
            if (root_val == inorder[root_idx])
                break;
        root.left = root_idx == in_i ? null : buildTreeHelper(preorder, inorder, in_i, root_idx - 1);
        root.right = root_idx == in_j ? null : buildTreeHelper(preorder, inorder, root_idx + 1, in_j);

        return root;
    }
}
