---
layout: post
title: Crack the LeetCode - Convert Sorted Array to Binary Search Tree
---

{{ page.title }}
================

<p class="meta">26 February 2014 - Shanghai </p>

**Problem**:  
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

**Example**:    
INPUT: [1,2,3,4]
OUTPUT: {2,1,3,#,#,#,4}

**Solution 0**:  
The solution is straightfoward using recursion: just choose the middle element to create a root node, and use recursive calls to generate left child and right child. 

*Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}  
public TreeNode sortedArrayToBST(int[] num) {
    return sortedArrayToBST_helper(num, 0, num.length-1);
}

private TreeNode sortedArrayToBST_helper(int[] num, int begin, int end) {
    if (begin >= end) {
        return begin == end ? new TreeNode(num[begin]) : null;
    }

    int div = (begin+end)/2;
    TreeNode root = new TreeNode(num[div]);
    root.left = sortedArrayToBST_helper(num, begin, div-1);
    root.right = sortedArrayToBST_helper(num, div+1, end);

    return root;
}
{% endhighlight %}
