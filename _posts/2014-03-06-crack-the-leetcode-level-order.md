---
layout: post
title: Crack the LeetCode - Binary Tree Level Order Traversal
---

{{ page.title }}
================

<p class="meta">06 March 2014 - Shanghai </p>

**Problem**:  
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

**Example**:    
INPUT: {3,9,20,#,#,15,7}  
OUTPUT: [[3],[9,20],[15,7]]

**Solution 0**:  
This problem is almost the same as the problem Level Order II.

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    ArrayList<ArrayList<TreeNode>> nodes = new ArrayList<ArrayList<TreeNode>>();
    ArrayList<TreeNode> cur = new ArrayList<TreeNode>(), last;
    if (root != null) {
        cur.add(root);
    }

    while (cur.size() != 0) {
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
    for (ArrayList<TreeNode> list : nodes) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (TreeNode node : list) {
            tmp.add(node.val);
        }
        result.add(tmp);
    }
    return result;}
{% endhighlight %}
