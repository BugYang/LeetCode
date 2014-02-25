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
The first solution I give is a O(n) algorithm. Even the idea is straightfoward: just traverse the array, keep the largest and least T and find the max Tmax-Tmin, which is the final solution, there are still some difficulties writing code.  

The first problem is how to handle the array with only one element which is negative. What's the result of array [-1], 0 or -1? The answer is -1 because the subarray must contain at least one number. If you don't handle this kind of special cases, you may get 0 as wrong answer. 

The second probem is how to initialize the minT. You can't simly set minT to be 0 which could cause trouble in the cases of the first problem, when minT actually should be a negative. You can't simply set minT to be A[0] because all elements may be postive, when minT actually should be 0. The answer is to handle break the first problem at first. Then you can assume there are more than one elements, so you can set minT to be 0.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int maxSubArray(int[] A) {
    int T = A[0], minT = A[0], max = A[0];
    for (int i = 1; i < A.length; i++) {
        T += A[i];
        max = T-minT > max ? T-minT : max;
        minT = T < minT ? T : minT;
    }
    return max;
}
{% endhighlight %}
