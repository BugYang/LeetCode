---
layout: post
title: Crack the LeetCode - Path Sum
---

{{ page.title }}
================

<p class="meta">07 March 2014 - Shanghai </p>

**Problem**:  
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

**Example**:    
INPUT: {5,4,8,11,#,13,4,7,2,#,#,#,1}, 22  
OUTPUT: true(5->4-11->2)

**Solution 0**:  
It can be solved by recursion easily.

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left != null || root.right != null) {
            return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
        } else {
            return sum == root.val;
        }
    }
}
{% endhighlight %}
