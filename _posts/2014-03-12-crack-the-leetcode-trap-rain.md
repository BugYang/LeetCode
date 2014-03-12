---
layout: post
title: Crack the LeetCode - Trapping Rain Water
---

{{ page.title }}
================

<p class="meta">11 March 2014 - Shanghai </p>

**Problem**:   
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

**Example**:   
INPUT: [0,1,0,2,1,0,1,3,2,1,2,1]  
OUTPUT: 6

**Solution 0**:  
The key obversation is, given a step, the water it traps depends on its left highest step and its right highest step. So you can make use of this key by finding lmax and rmax for each step. But this takes O(n^2) time and can't pass OJ, so you need optimize it. Since you traverse the steps from left to right, so it's possible that the rmax of step i is also the rmax of step i+1, so you don't need to recalculate rmax of step i+1 until you meet rmax. The worst case is still O(n^2), but for most case it's much better.

*Time Complexity*:O(n^2)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int trap(int[] A) {
    int total = 0, lmax = 0, rmax = 0;
    for (int i = 0; i < A.length; i++) {
        if (i >= rmax) {
            rmax = i;
            for (int r = i+1; r < A.length; r++) {
                rmax = A[r] > A[rmax] ? r : rmax;
            }
        }
        lmax = tA[i] > A[lmax] ? i : lmax;
        total += Math.min(A[lmax], A[rmax]) - A[i];
    }
    return total;
}
{% endhighlight %}
