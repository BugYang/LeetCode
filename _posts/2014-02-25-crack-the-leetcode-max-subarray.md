---
layout: post
title: Crack the LeetCode - Maximum Subarray
---

{{ page.title }}
================

<p class="meta">25 February 2014 - Shanghai </p>

**Problem**:  
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

**Example**:    
INPUT: [-2,1,-3,4,-1,2,1,-5,4]  
OUTPUT: 6 (sum of [4,-1,2,1]) 

**NOTE**:  
Actually, I've met this problem before and failed to give a solution. Then I found [this slides](http://www.cse.ust.hk/faculty/golin/COMP271Sp03/Notes/L02.pdf) really useful. Only after learning this slides I could give the following solutions. 

**Solution 0**:  
The first solution I give is a O(n) algorithm. Even the idea is straightfoward: just traverse the array, keep the largest and least T and find the max Tmax-Tmin, which is the final solution, there is a tricky point. The algorithm is iterative, and each iteration need a base iteration. So you have to handle the first iteration manually, which means you initialize T, Tmin, Tmax approperly.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int maxSubArray(int[] A) {
    int T = A[0], minT = Math.min(0, A[0]), max = A[0];
    for (int i = 1; i < A.length; i++) {
        T += A[i];
        max = T-minT > max ? T-minT : max;
        minT = T < minT ? T : minT;
    }
    return max;
}
{% endhighlight %}
