---
layout: post
title: Crack the LeetCode - Maximum Depth of Binary Tree
---

{{ page.title }}
================

<p class="meta">20 February 2014 - Shanghai </p>

**Problem**:  
Given a binary tree, find its depth.

**Example**:  
INPUT: {}  
OUTPUT: 0  
INPUT: {1, #, 2}  
OUTPUT: 2

**Solution 0**:  
It is a very easy problem since we can simply use recursive function to solve it. The only pitfall is that you may forget to consider the input node is null.  
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
        if (root == null) {
            return 0;
        }
        int leftDepth = 0, rightDepth = 0;
        if (root.left != null) {
            leftDepth = maxDepth(root.left);
        }
        if (root.right != null) {
            rightDepth = maxDepth(root.right);
        }

        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}
{% endhighlight %}

