---
layout: post
title: Crack the LeetCode - Single Number II
---

{{ page.title }}
================

<p class="meta">28 February 2014 - Shanghai </p>

**Problem**:  
Given an array of integers, every element appears three times except for one. Find that single one.

**Example**:    
INPUT: {1,1,1,2}
OUTPUT: 2 

**Solution 0**:  
You can still use the similar solution in single number problem.

*Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}  
public int singleNumber(int[] A) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int i;
    for (i = 0; i < A.length; i++) {
        map.put(A[i], map.containsKey(A[i]) ? map.get(A[i])+1 : 1);
    }

    for (i = 0; i < A.length; i++) {
        if (map.get(A[i]) != 3) {
            break;
        }
    }
    return A[i];
}
{% endhighlight %}

**Solution 1**:  
Or you can use non-recursive method to solve it, which is more challenging. It is the common case that you have to use stack convert recursive method to iterative method. And also, in this problem, using one stack may incur false positive, so I will use two stack here.

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }
    Stack<TreeNode> lstack = new Stack<TreeNode>(), rstack = new Stack<TreeNode>();
    lstack.push(root.left);
    rstack.push(root.right);
    while (!lstack.empty() && !rstack.empty()) {
        TreeNode lnode = lstack.pop(), rnode = rstack.pop();
        if (lnode != null && rnode != null) {
            if (lnode.val != rnode.val) {
                return false;
            }
            lstack.push(lnode.left);
            rstack.push(rnode.right);
            rstack.push(lnode.right);
            lstack.push(rnode.left);
        } else if (lnode != rnode) {
            return false;
        }
    }
    return true;
}
{% endhighlight %}
