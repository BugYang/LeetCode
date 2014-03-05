---
layout: post
title: Crack the LeetCode - Unique Paths
---

{{ page.title }}
================

<p class="meta">05 March 2014 - Shanghai </p>

**Problem**:  
A robot is located at the top-left corner of a m x n grid. The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid. How many possible unique paths are there?

**Example**:    
INPUT: 2,1  
OUTPUT: 1  

**Solution 0**:  
It's a typical combination algebra problem, and its solution is C(m-1, m+n-2). The only pitfall is you may meet integer overflow when computing the combination. Actually, the problem itself has some problem because its result may be greater than 2^31-1. However, since the function prototype specifies the return value type is integer, you could make some assumptions based on this. In my solution, I use long to store intermediate result, and I do division as soon as possible in order to avoid overflow.

*Time Complexity*:O(m+n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int uniquePaths(int m, int n) {
    long result = 1, x = 2;
    for (int i = m; i <= m+n-2; i++) {
        long a = result, b = i;
        result = a * b;
        while (result%x == 0 && x < n) {
            result /= x++;
        }
    }
    return (int)result;
}
{% endhighlight %}

