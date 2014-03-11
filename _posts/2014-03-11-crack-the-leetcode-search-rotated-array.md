---
layout: post
title: Crack the LeetCode - Search in Rotated Sorted Array
---

{{ page.title }}
================

<p class="meta">11 March 2014 - Shanghai </p>

**Problem**:   
Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are given a target value to search. If found in the array return its index, otherwise return -1. You may assume no duplicate exists in the array.

**Example**:   
INPUT: [4,5,6,7,0,1,2], 7    
OUTPUT: 3

**Solution 0**:  
Actually, the OJ accepts the brute-force solution for this problem. Some people argue that bf solution has better cache hit rates, so it may be better than binarySearch solution.

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
But this is an algorithm problem, so you should find more algorithmically elegant solution. You can modify the binarySearch by taking advantage of the rotated sorted array's property. Be careful about the edge cases!

*Time Complexity*:O(log(n))  
*Space Complexity*:O(1)  

{% highlight java %}  
public int search_bs(int[] A, int target) {
    return searchHelper(A, 0, A.length-1, target);
}

public int searchHelper(int[] A, int begin, int end, int target) {
    while (begin < end) {
        int mid = (begin + end)/2;
        if (A[mid] == target) {
            return mid;
        } else if (A[begin] <= A[mid]) {
            if (A[begin] <= target && target < A[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
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
