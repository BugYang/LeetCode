---
layout: post
title: Crack the LeetCode - Search for a Range
---

{{ page.title }}
================

<p class="meta">19 March 2014 - Shanghai </p>

**Problem**:   
Given a sorted array of integers, find the starting and ending position of a given target value. Your algorithm's runtime complexity must be in the order of O(log n). If the target is not found in the array, return [-1, -1].

**Example**:   
INPUT:  [5,7,7,8,8,10], 8  
OUTPUT:  [3,4] 

**Solution 0**:  
This problem can be broken into two parts: find the left most target, find the right most target. So you can customize the standard binary search. Be careful about the array bounders!

*Time Complexity*:O(log(n))  
*Space Complexity*:O(1)  

{% highlight java %}  
public int[] searchRange(int[] A, int target) {
    int[] result = new int[2];
    result[0] = binarySearchFirst(A, target);
    result[1] = binarySearchLast(A, target);
    return result;
}

public int binarySearchFirst(int[] A, int target) {
    int l = 0, h = A.length-1, m;
    while (l <= h && l >= 0 && h >= 0) {
        m = (h+l)/2;
        if (A[m] == target) {
            if (m == 0 || A[m-1] != A[m]) {
                return m;
            } else {
                h = m-1;
            }
        } else if (A[m] < target) {
            l = m+1;
        } else {
            h = m-1;
        }
    }           
    return -1;
}

public int binarySearchLast(int[] A, int target) {
    int l = 0, h = A.length-1, m;
    while (l <= h && l >= 0 && h >= 0) {
        m = (h+l)/2;
        if (A[m] == target) {
            if (m == A.length-1 || A[m+1] != A[m]) {
                return m;
            } else {
                l = m+1;
            }
        } else if (A[m] < target) {
            l = m+1;
        } else {
            h = m-1;
        }
    }           
    return -1;
}
{% endhighlight %}
