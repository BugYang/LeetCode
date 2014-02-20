---
layout: post
title: Crack the LeetCode - Unique Binary Search Trees
---

{{ page.title }}
================

<p class="meta">20 February 2014 - Shanghai </p>

**Problem**:  
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

**Example**:  
INPUT: 3  
OUTPUT: 5  

**Solution 0**:  
The keypoint is to find that F(n) can be calculated using F(0)~F(n-1). That is, given n, beyond the root node, there may be 0 on the left and n-1 on the right, or 1 on the left and n-2 on the right, and so on. So it's easy to find F(n) = F(0) * F(n-1) + F(1) * F(n-2) + ... + F(n-1) * F(0). Then you can use recursive function to calculate F(n).  
*Time Complexity*:O(2^n)  
*Space Complexity*:O(1)  

{% highlight java %}
public int numTrees(int n) {
    int result = 0;
    if (n <= 1) {
        result = 1;
    } else {
        for (int i = 0; i < n; i++) {
            result += numTrees(i) * numTrees(n-1-i);
        }
    }
    return result;
}
{% endhighlight %}

**Solution 1**:  
The previous method is very clear but has bad time complexity. To improve it, you have to notice there are many unnecessary, duplicate recursive call. So you can memorize the result to avoid duplicate calls.  
*Time Complexity*:O(n^2)  
*Space Complexity*:O(n)  

{% highlight java %}
public int numTrees(int n) {
    int[] result = new int[n + 1];
    for (int i = 0; i <= n; i++) {
        if (i <= 1) {
            result[i] = 1;
        } else {
            result[i] = 0;
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i-1-j];
            }
        }
    }
    return result[n];
}
{% endhighlight %}

