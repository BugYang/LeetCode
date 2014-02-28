---
layout: post
title: Crack the LeetCode - Remove Duplicates from Sorted Array
---

{{ page.title }}
================

<p class="meta">27 February 2014 - Shanghai </p>

**Problem**:  
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length. Do not allocate extra space for another array, you must do this in place with constant memory.

**Example**:    
INPUT: [1,1,2]   
OUTPUT: [1,2], 2

**Solution 0**:  
This problem is similar to the 'linked list' version. You can keep track of the new length and last viewed element. Whenever meeting a different element, you can move the new one and increment the new length.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int removeDuplicates(int[] A) {
    if (A.length == 0) {
        return 0;
    }

    int len = 1, last = A[0];
    for (int i = 1; i < A.length; i++) {
        if (A[i] != last) {
            A[len++] = A[i];
            last = A[i];
        }
    }

    return len;
}
{% endhighlight %}
