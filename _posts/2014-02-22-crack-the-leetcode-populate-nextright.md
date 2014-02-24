---
layout: post
title: Crack the LeetCode - Populating Next Right Pointers in Each Node 
---

{{ page.title }}
================

<p class="meta">22 February 2014 - Shanghai </p>

**Problem**:  
Given a perfect binary tree (each node contains left, right and next pointer), populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL. You may only use constand extra space.

**Example**:  
INPUT: {1,2,3,4,5,6,7}   
OUTPUT: {1-null,2-3,3-null,4-5,5-6,6-7,7-null}  

**Solution 0**:  
Since I couldn't figure out the solution at first, I find an usable article and give its link here: http://leetcode.com/2010/03/first-on-site-technical-interview.html  
*Time Complexity*:O(V)  
*Space Complexity*:O(1)  

{% highlight java %}
public void connect(TreeLinkNode root) {
    if (root == null) {
        return;
    }
    if (root.left != null) {
        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
    }
    connect(root.left);
    connect(root.right);
}
{% endhighlight %}

**NOTE**:
After reading this article, I find the main difficulty to solve this problem is failing to use the intermediate result, i.e, the next pointer...
