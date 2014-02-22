---
layout: post
title: Crack the LeetCode - Search Insert Position
---

{{ page.title }}
================

<p class="meta">22 February 2014 - Shanghai </p>

**Problem**:  
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.

**Example**:  
INPUT: [1,3,5,6] 5   
OUTPUT: 2   
INPUT: [1,3,5,6] 7   
OUTPUT: 4   
INPUT: [1,3,5,6] 0   
OUTPUT: 0   

**Solution 0**:  
You can simply find the right position by traverse the array...   
*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}
public int searchInsert(int[] A, int target) {
    int i = 0;
    while (i < A.length && A[i] < target) {
        i++;
    }
    return i;
}
{% endhighlight %}

