---
layout: post
title: Crack the LeetCode - Remove Duplicates from Sorted Array II
---

{{ page.title }}
================

<p class="meta">10 March 2014 - Shanghai </p>

**Problem**:   
Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?

**Example**:   
INPUT: [1,1,1,2,2,3]    
OUTPUT: [1,1,2,2,3],5

**Solution 0**:  
The solution is almost the same as the original problem, except that you need to view last two elements in new array.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int removeDuplicates(int[] A) {
    if (A.length < 3) {
        return A.length;
    }

    int len = 2;
    for (int i = 2; i < A.length; i++) {
        if (A[i] != A[len-2]) {
            A[len++] = A[i];
        }
    }
    return len;
}
{% endhighlight %}
