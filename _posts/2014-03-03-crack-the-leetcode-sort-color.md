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
