---
layout: post
title: Crack the LeetCode - Binary Tree Inorder Traversal
---

{{ page.title }}
================

<p class="meta">24 February 2014 - Shanghai </p>

**Problem**:  
Given a binary tree, return the inorder traversal of its nodes' values.

**Example**:    
INPUT: {1,#,2,3}  
OUTPUT:  [1,3,2]

**Solution 0**:  
It's easy to think of the recursive solution.    

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root != null) {
        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }
    }

    return result;
}
{% endhighlight %}


**Solution 1**:  
But a non-recursive solution is not that easy, and I failed to think up the solution at first. Only after reading some articles, I got the idea. Beginning from the root, we shouldn't visit it now but push it into stack, and then we move to its left child. We continue to do that until we meet null. Then we pop the nodes that have no right child in the stack until any node has right child. Then we restart the whole process from this node.  

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if (root == null) {
        return result;
    }

    do {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        do {
            root = stack.pop();
            result.add(root.val);
        } while (root.right == null && stack.empty() == false);

        root = root.right;

    } while (root != null);

    return result;
}
{% endhighlight %}
