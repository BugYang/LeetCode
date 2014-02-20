---
layout: post
title: Crack the LeetCode - Reverse Integer
---

{{ page.title }}
================

<p class="meta">20 February 2014 - Shanghai </p>

**Problem**:  
Reverse digits of an integer.

**Example**:  
INPUT: 123  
OUTPUT: 321  
INPUT: -123  
OUTPUT: -321  

**Solution 0**:  
It's not easy to reverse an int but easy to reverse a string. So we can convert int to string, reverse it, and then covert it back to int.  
*Time Complexity*:O(log(n))  
*Space Complexity*:O(log(n))  

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

**PS:**  
Consider the following questions:  
1. what about the int's last digit is 0?  
2. what about the reversed int may overflow?  
People always wouldn't notice these problems, at least so did I. So next time when you write code, please think of all the corners before.
