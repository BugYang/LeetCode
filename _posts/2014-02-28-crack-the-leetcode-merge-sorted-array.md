---
layout: post
title: Crack the LeetCode - Merge Sorted Array
---

{{ page.title }}
================

<p class="meta">28 February 2014 - Shanghai </p>

**Problem**:  
Given two sorted integer arrays A and B, merge B into A as one sorted array.
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

**Example**:    
INPUT: [1,5],[3]
OUTPUT: [1,3,5] 

**Solution 0**:  
In this problem, you may find it difficult to sort arrays from the beginning since it needs lots of element movings. But if you sort arrays from the ending, the solution will be obvious and straightforward.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public void merge(int A[], int m, int B[], int n) {
    int i = m+n-1;
    while (m > 0 && n > 0) {
        A[i--] = A[m-1] > B[n-1] ? A[m-- -1] : B[n-- -1];
    }
    while (m > 0) {
        A[i--] = A[m-- -1];
    }
    while (n > 0) {
        A[i--] = B[n-- -1];
    }
}
{% endhighlight %}
