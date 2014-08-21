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
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0)
			return null;

		ArrayList<Integer> postorder_list = new ArrayList<Integer>();
		for (int i = inorder.length - 1; i >= 0; i--)
			postorder_list.add(postorder[i]);
		return buildTreeHelper(inorder, 0, inorder.length - 1, postorder_list);
	}

	public TreeNode buildTreeHelper(int[] inorder, int in_i, int in_j, ArrayList<Integer> postorder) {
		int root_idx, root_val;
		TreeNode root;

		root_val = postorder.get(0);
		postorder.remove(0);
		for (root_idx = in_i; root_idx <= in_j; root_idx++)
			if (inorder[root_idx] == root_val)
				break;
		root = new TreeNode(root_val);
		root.right = root_idx == in_j ? null : buildTreeHelper(inorder, root_idx + 1, in_j, postorder);
		root.left = root_idx == in_i ? null : buildTreeHelper(inorder, in_i, root_idx - 1, postorder);

		return root;
	}
}
