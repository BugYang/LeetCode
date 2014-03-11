---
layout: post
title: Crack the LeetCode - Search in Rotated Sorted Array II
---

{{ page.title }}
================

<p class="meta">11 March 2014 - Shanghai </p>

**Problem**:   
Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed? Would this affect the run-time complexity? How and why? Write a function to determine if a given target is in the array.

**Example**:   
INPUT: [4,5,6,7,0,1,1,1,2], 7    
OUTPUT: 3

**Solution 0**:  
The brute-force search is still ok.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int search_bf(int[] A, int target) {
    for (int i = 0; i < A.length; i++) {
        if (A[i] == target) {
            return i;
        }
    }
    return -1;
}
{% endhighlight %}

**Solution 1**:  
For binary search, you have to make a small modification: if you find A[begin] equals A[mid], you can't reduce the searching space by half. So you can only move begin one step forward. The worst case is that all elements are the same, so the time complexity is n. But for most case, the time complexity is still almost log(n) 

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public boolean search(int[] A, int target) {
    return searchHelper(A, 0, A.length-1, target) != -1;
}

public int searchHelper(int[] A, int begin, int end, int target) {
    while (begin < end) {
        int mid = (begin + end)/2;
        if (A[mid] == target) {
            return mid;
        } else if (A[begin] < A[mid]) {
            if (A[begin] <= target && target < A[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        } else if (A[begin] == A[mid]) {
            begin += 1;
        } else {
            if (A[mid] < target && target <= A[end]) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
    }
    return A[begin] == target ? begin : -1;
}
{% endhighlight %}
