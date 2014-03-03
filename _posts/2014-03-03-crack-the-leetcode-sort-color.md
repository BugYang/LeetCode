---
layout: post
title: Crack the LeetCode - Sort Colors
---

{{ page.title }}
================

<p class="meta">03 March 2014 - Shanghai </p>

**Problem**:  
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue. Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

**Example**:    
INPUT: [0,1,0,1,2]
OUTPUT: [0,0,1,1,2]

**Solution 0**:  
Since we know what elements in array exactly are, we can use counting sorting.

*Time Complexity*:O(1)  
*Space Complexity*:O(n)  

{% highlight java %}  
public void sortColors(int[] A) {
    int[] cnt = new int[3];
    for (int i : A) {
        cnt[i]++;
    }
    int i = 0;
    for (int j = 0; j < 3; j++) {
        for (int k = 0; k < cnt[j]; k++) {
            A[i++] = j;
        }
    }
}
{% endhighlight %}

**Solution 1**:  
The algorithm above need 2 passes, which is actuall unnecessay. Consider such scenario: in the array A, A[0:p0] contain 0, A[p1:p2] contain 1, A[p2:] contain 2, how to add one more element which may be 0,1 or 2? After figuring this out, you can surely give a one-pass solution.

*Time Complexity*:O(1)  
*Space Complexity*:O(n)  

{% highlight java %}  
public void sortColors(int[] A) {
    int p0 = -1, p1 = -1, p2 = -1;
    for (int i = 0; i < A.length; i++) {
        if (A[i] == 2) {
            A[++p2] = 2;
        } else if (A[i] == 1) {
            A[++p2] = 2;
            A[++p1] = 1;
        } else {
            A[++p2] = 2;
            A[++p1] = 1;
            A[++p0] = 0;
        }
    }
}
{% endhighlight %}

**NOTE**:  
I find it really useful to solve problem using this method: first, you assume an intermediate case which owns all properties the result should own; second, you figure out how to extern this case one step further; third, you set the most basic case manually and repeat extending this case until you get the result, which is a solution, either iterative or recursive.
