---
layout: post
title: Crack the LeetCode - Binary Tree Preorder Traversal
---

{{ page.title }}
================

<p class="meta">22 February 2014 - Shanghai </p>

**Problem**:  
Given a binary tree, return the preorder traversal of its nodes' values.

**Example**:  
INPUT: {1,#,2,3,#}  
OUTPUT:  [1, 2, 3]

**Solution 0**:  
It's easy to think of the recursive solution.    
*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}
public ArrayList<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root != null) {
        result.add(root.val);
        if (root.left != null) {
            result.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            result.addAll(preorderTraversal(root.right));
        }
    }
    return result;
}
{% endhighlight %}


**Solution 1**:  
To make it interesting, we can try to find a iterative solution. Since we can solve it recursively, we can use stack to simulate the recursion.  
*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}
public ArrayList<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if (root != null) {
        stack.push(root);
    }
    while (stack.empty() == false) {
        TreeNode current = stack.pop();
        result.add(current.val);
        if (current.right != null) {
            stack.push(current.right);
        }
        if (current.left != null) {
            stack.push(current.left);
        }
    }
    return result;
}
{% endhighlight %}

