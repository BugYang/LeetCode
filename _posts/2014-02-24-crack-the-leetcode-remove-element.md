---
layout: post
title: Crack the LeetCode - Remove Element
---

{{ page.title }}
================

<p class="meta">24 February 2014 - Shanghai </p>

**Problem**:  
Given an array and a value, remove all instances of that value in place and return the new length. The order of elements can be changes. It doesn't matter what you leave beyond the new length.

**Example**:    
INPUT: {1,2,3,3,5}, 3  
OUTPUT: {1,2,5}

**Solution 0**:  
The solution is obvious. You can just traverse the array, and swap the element to the tail if the given element found.  

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int removeElement(int[] A, int elem) {
    int len = A.length;
    for (int i = 0; i < len; i++) {
        if (A[i] == elem) {
            int t = A[i];
            A[i--] = A[--len];
            A[len] = t;
        }
    }
    return len;
}
{% endhighlight %}
