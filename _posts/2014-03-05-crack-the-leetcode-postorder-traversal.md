---
layout: post
title: Crack the LeetCode - Postorder Traversal
---

{{ page.title }}
================

<p class="meta">05 March 2014 - Shanghai </p>

**Problem**:  
Given a binary tree, return the postorder traversal of its nodes' values.

**Example**:    
INPUT: {1,#,2,3}  
OUTPUT: [3,2,1]  

**Solution 0**:  
The recursive solution is obvious.

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
        return result;
    }
    result.addAll(postorderTraversal(root.left));
    result.addAll(postorderTraversal(root.right));
    result.add(root.val);
    return result;
}
{% endhighlight %}

**Solution 1**:  
The iterative solution is a little bit difficult. Actually, the traversal contain two kinds of operations: extract a node(go down the tree) and visit a node. Only extracted nodes should be visited, so you should classify two kinds. You can use extract-stack to record which nodes should be extract next and use visit-stack to record which nodes should be visited. Extracting a node means you push its children into extract-stack and push itself into visit-stack. By doing so, you can keep the reverse-postorder in visit-stack, so you can get postorder by poping visit-stack until becoming empty.

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> extract = new Stack<TreeNode>();
    Stack<TreeNode> traversal = new Stack<TreeNode>();

    if (root != null) {
        extract.push(root);
    }
    while (!extract.empty()) {
        TreeNode cur = extract.pop();
        if (cur.left != null) {
            extract.push(cur.left);
        }
        if (cur.right != null) {
            extract.push(cur.right);
        }
        traversal.push(cur);
    }

    while (!traversal.empty()) {
        TreeNode cur = traversal.pop();
        result.add(cur.val);
    }
    return result;
}
{% endhighlight %}


**Solution 2**:  
There is another iterative solution which I failed to figure out. After reading this [article](http://leetcode.com/2010/10/binary-tree-post-order-traversal.html), I got the idea.

*Time Complexity*:O(V)  
*Space Complexity*:O(Height) 

{% highlight java %}  
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> s = new Stack<TreeNode>();
    TreeNode prev = null, cur;
    if (root != null) {
        s.push(root);
    }
    while (!s.empty()) {
        cur = s.peek();
        if (prev == null || cur == prev.left || cur == prev.right) {
            if (cur.left != null) {
                s.push(cur.left);
            } else if (cur.right != null) {
                s.push(cur.right);
            } else {
                result.add(cur.val);
                s.pop();
            }
        } else if (prev == cur.left) {
            if (cur.right != null) {
                s.push(cur.right);
            } else {
                result.add(cur.val);
                s.pop();
            }
        } else if (prev == cur.right) {
            result.add(cur.val);
            s.pop();
        }
        prev = cur;
    }
    return result;
}
{% endhighlight %}
