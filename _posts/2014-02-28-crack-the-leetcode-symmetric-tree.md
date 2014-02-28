---
layout: post
title: Crack the LeetCode - Symmetric Tree 
---

{{ page.title }}
================

<p class="meta">28 February 2014 - Shanghai </p>

**Problem**:  
Given a binary tree, check whether it is symmetric.

**Example**:    
INPUT: {1,2,2,#,3,3}
OUTPUT: true

**Solution 0**:  
Obviously, it is easy to solve this problem using recursive function.

*Time Complexity*:O(n)  
*Space Complexity*:O(logn)  

{% highlight java %}  
public boolean isSymmetric(TreeNode root) {
    return root == null ? true : cmpNode(root.left, root.right);
}

public boolean cmpNode(TreeNode node1, TreeNode node2) {
    if (node1 == null || node2 == null) {
        return node1 == node2;
    } else {
        return node1.val == node2.val 
            && cmpNode(node1.left, node2.right) && cmpNode(node1.right, node2.left);
    }
}
{% endhighlight %}
