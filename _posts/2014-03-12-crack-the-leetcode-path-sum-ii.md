---
layout: post
title: Crack the LeetCode - Path Sum II
---

{{ page.title }}
================

<p class="meta">12 March 2014 - Shanghai </p>

**Problem**:   
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

**Example**:   
INPUT: {5,4,8,11,#,13,4,7,#,#,2,#,#,5,1}, 22
OUTPUT: [[5,4,11,2], [5,8,4,5]]

**Solution 0**:  
Obviously, you can solve it using recursion. Only one thing need your notice: you may simplify your code by returning empty path for null root and 0 sum, but this is actually a wrong assumption since it can't pass the test case {},0.

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
        return paths;
    }
    if (root.left == null && root.right == null) {
        if (root.val == sum) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            path.add(root.val);
            paths.add(path);
        }
    } else {
        if (root.left != null) {
            paths.addAll(pathSum(root.left, sum-root.val));
        }
        if (root.right != null) {
            paths.addAll(pathSum(root.right, sum-root.val));
        }
        for (ArrayList<Integer> path : paths) {
            path.add(0, root.val);
        }
    }

    return paths;
}
{% endhighlight %}
