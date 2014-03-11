---
layout: post
title: Crack the LeetCode - Minimum Depth of Binary Tree
---

{{ page.title }}
================

<p class="meta">11 March 2014 - Shanghai </p>

**Problem**:   
Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

**Example**:   
INPUT: {1,2}
OUTPUT: 2

**Solution 0**:  
There seems to be an easy recursive solution (and also a trap). Be careful that the minimum depth need a leaf node! That's exactly why the example output is 2 instead of 1.

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    if (root.left != null && root.right != null) {
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    } else {
        return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
{% endhighlight %}
