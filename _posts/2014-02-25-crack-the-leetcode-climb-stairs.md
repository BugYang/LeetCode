---
layout: post
title: Crack the LeetCode - Climbing Stairs
---

{{ page.title }}
================

<p class="meta">25 February 2014 - Shanghai </p>

**Problem**:  
Given a stair case with n steps, you can either climb 1 or 2 steps, so how many distinct way you climb to the top?

**Example**:    
INPUT: 1  
OUTPUT: 1  
INPUT: 3  
OUTPUT: 3


**Solution 0**:  
The key point is to break F(n) to F(n-1)+F(n-2). That is, if you choose 1 step at first, you have F(n-1) choices then, or if you choose 2 steps at first, you have F(n-2) choices. Then you can find the solution is elements in Fibonacci sequences.  

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int climbStairs(int n) {
    int a = 1, b = 1, result = 1;
    for (int i = 2; i <= n; i++) {
        result = a+b;
        a = b;
        b = result;
    }
    return result;
}
{% endhighlight %}