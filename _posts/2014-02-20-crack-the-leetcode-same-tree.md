---
layout: post
title: Crack the LeetCode - Same Tree
---

{{ page.title }}
================

<p class="meta">20 February 2014 - Shanghai </p>

**Problem**:  
Given two binary trees, write a function to check if they are equal or not.

**Example**:  
INPUT: {} {1, 2} 
OUTPUT: false  
INPUT: {1, 2} {1, 2}
OUTPUT: true

**Solution 0**:  
This problem is similar with the last one, maximum binary tree depth. So we could still use recursive function to solve it.  
*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}
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
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
{% endhighlight %}

