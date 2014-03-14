---
layout: post
title: Crack the LeetCode - Longest Consecutice Sequence
---

{{ page.title }}
================

<p class="meta">14 March 2014 - Shanghai </p>

**Problem**:   
Given an unsorted array of integers, find the length of the longest consecutive elements sequence. Your algorithm should run in O(n) complexity.

**Example**:   
INPUT: [100,4,200,1,3,2]  
OUTPUT: 4

**Solution 0**:  
The key observation is, given i, you need to find i+1 or i-1 in O(1) time. So the keypoint is to use hash method. You can put all element in a hashset, then you find the length of each element's consecutive sequence, and then update the max length.

*Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}  
public int longestConsecutive(int[] num) {
    Set<Integer> set = new HashSet<Integer>();
    for (int i : num) {
        set.add(i);
    }

    int len, max = 0;
    for (int i : num) {
        len = 0;
        int left = i, right = i+1;
        while (set.contains(left)) {
            set.remove(left--);
            len++;
        }
        while (set.contains(right)) {
            set.remove(right++);
            len++;
        }
        max = Math.max(max, len);
    }
    return max;
}
{% endhighlight %}
