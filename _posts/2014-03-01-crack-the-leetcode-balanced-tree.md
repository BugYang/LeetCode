---
layout: post
title: Crack the LeetCode - Balanced Binary Tree
---

{{ page.title }}
================

<p class="meta">01 March 2014 - Shanghai </p>

**Problem**:  
Given a binary tree, determine if it is height-balanced. For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

**Example**:    
INPUT: {1,2,3}  
OUTPUT: true

**Solution 0**:  
Once you understand what does 'balanced' mean, you will surely find the recursive function is the most straightforward solution. 

*Time Complexity*:O(?)  
*Space Complexity*:O(?)  

{% highlight java %}  
public boolean isBalanced(TreeNode root) {
    if (root == null) {
        return true;
    }
    return isBalanced(root.left) && isBalanced(root.right) &&
        Math.abs(getHeight(root.left) - getHeight(root.right)) < 2;
}

public int getHeight(TreeNode root) {
    return root == null ? 0 : (1 + Math.max(getHeight(root.left), getHeight(root.right)));
}
{% endhighlight %}
