---
layout: post
title: Crack the LeetCode - Sum Root to Leaf Numbers
---

{{ page.title }}
================

<p class="meta">11 March 2014 - Shanghai </p>

**Problem**:   
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

**Example**:   
INPUT: {1,2,3}
OUTPUT: 25

**Solution 0**:  
There is an easy recursive solution (and no trap). 

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public int sumNumbers(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return sumNumbersHelper(root, 0);
}

public int sumNumbersHelper(TreeNode root, int base) {
    base = base * 10 + root.val;
    int result = 0;
    if (root.left != null) {
        result += sumNumbersHelper(root.left, base);
    }
    if (root.right != null) {
        result += sumNumbersHelper(root.right, base);
    }
    return result == 0 ? base : result;
}
{% endhighlight %}

**Solution 1**:  
Another solution is to use level-order traversal.

*Time Complexity*:O(V)  
*Space Complexity*:O(V)  

{% highlight java %}  
public int sumNumbers(TreeNode root) {
    if (root == null) {
        return 0;
    }

    Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
    Queue<Integer> intQ = new LinkedList<Integer>();
    int result = 0, cnt = 1;
    nodeQ.add(root);
    intQ.add(0);

    while (cnt != 0) {
        int new_cnt = 0;
        for (int i = 0; i < cnt; i++) {
            TreeNode node = nodeQ.poll();
            int base = intQ.poll();
            if (node.left == null && node.right == null) {
                result += base * 10 + node.val;
            }
            if (node.left != null) {
                nodeQ.add(node.left);
                intQ.add(base * 10 + node.val);
                new_cnt++;
            }
            if (node.right != null) {
                nodeQ.add(node.right);
                intQ.add(base * 10 + node.val);
                new_cnt++;
            }
        }
        cnt = new_cnt;
    }

    return result;
}
{% endhighlight %}
