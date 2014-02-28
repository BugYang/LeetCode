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

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

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

**Solution 1**:  
Or you can use non-recursive method to solve it, which is more challenging. It is the common case that you have to use stack convert recursive method to iterative method. And also, in this problem, using one stack may incur false positive, so I will use two stack here.

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public boolean isSymmetric(TreeNode root) {
    Stack<TreeNode> lstack = new Stack<TreeNode>(), rstack = new Stack<TreeNode>();
    if (root && root.left) {
        lstack.push(root.left);
    }
    if (root && root.right) {
        rstack.push(root.right);
    }
    while (lstack.size() == rstack.size()) {
        if (lstack.empty() && rstack.empty()) {
            return true;
        }
        TreeNode lnode = lstack.pop(), rnode = rstack.pop();
        if (lnode.val != rnode.val) {
            return false;
        }
        if (lnode.left) {
            lstack.push(lnode.left);
        }
        if (rnode.right) {
            rstack.push(rnode.right);
        }
        if (lnode.right) {
            rstack.push(lnode.right);
        }
        if (rnode.left) {
            lstack.push(rnode.left);
        }
    }
    return false;
}
{% endhighlight %}
