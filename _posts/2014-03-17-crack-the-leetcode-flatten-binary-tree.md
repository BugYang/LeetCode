---
layout: post
title: Crack the LeetCode - Flatten Binary Tree to Linked List
---

{{ page.title }}
================

<p class="meta">18 March 2014 - Shanghai </p>

**Problem**:   
Given a binary tree, flatten it to a linked list in-place.Given a binary tree, flatten it to a linked list in-place.

**Example**:   
INPUT: {1,2,5,3,4,#,6}  
OUTPUT: ...

**Solution 0**:  
A key observation is the flattened tree seems like the result of pre-order traversal of the original tree. So you can just do pre-order traversal and generate the result.

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public void flatten(TreeNode root) {
    if (root == null) {
        return;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);

    TreeNode cur, last = null;
    while (!stack.empty()) {
        cur = stack.pop();
        if (cur.right != null) {
            stack.push(cur.right);
        }
        if (cur.left != null) {
            stack.push(cur.left);
        }

        cur.left = null;
        if (last != null) {
            last.right = cur;
        }
        last = cur;
    }
}
{% endhighlight %}

**Solution 1**:  
Another way to break this problem is to use recursive method, not recursive version of pre-order traversal, but flatten the tree recursively. Let's assume the left and right children has been flattened, what will you do next? Just insert the left sequence between the root and the right sequence. 

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public void flatten(TreeNode root) {
    if (root != null) {
        root = flattenHelper(root);
    }
}

public TreeNode flattenHelper(TreeNode root) {
    if (root.right != null) {
        root.right = flattenHelper(root.right);
    }
    if (root.left != null) {
        root.left = flattenHelper(root.left);

        TreeNode leftTail = root.left;
        while (leftTail.right != null) {
            leftTail = leftTail.right;
        }
        leftTail.right = root.right;
        root.right = root.left;
        root.left = null;
    }
    return root;
}
{% endhighlight %}
