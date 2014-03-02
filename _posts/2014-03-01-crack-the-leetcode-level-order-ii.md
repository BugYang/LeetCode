---
layout: post
title: Crack the LeetCode - Binary Tree Level Order Traversal II
---

{{ page.title }}
================

<p class="meta">01 March 2014 - Shanghai </p>

**Problem**:  
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

**Example**:    
INPUT: {3,9,20,#,#,15,7}  
OUTPUT: [[15,7], [9,20], [3]]

**Solution 0**:  
There's almost nothing different from normal level order traversal...

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    ArrayList<ArrayList<TreeNode>> nodes = new ArrayList<ArrayList<TreeNode>>();
    ArrayList<TreeNode> cur = new ArrayList<TreeNode>(), last;

    if (root != null) {
        cur.add(root);
    }
    while (!cur.isEmpty()) {
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
    for (int i = nodes.size()-1; i >= 0; i--) {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for (TreeNode node : nodes.get(i)) {
            vals.add(node.val);
        }
        result.add(vals);
    }
    return result;
}
{% endhighlight %}
