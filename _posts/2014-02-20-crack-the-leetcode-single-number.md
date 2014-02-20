---
layout: post
title: Crack the LeetCode - Single Number
---

{{ page.title }}
================

<p class="meta">20 February 2014 - Shanghai </p>

**Problem**:  
Given an array of int, within which every element appears twice except for one, your task is to find that single one.

**Example**:  
INPUT: 1,1,2,2,3  
OUTPUT: 3

**Solution 0**:  
The most simple solution is very straightfoward, just to count all the elements and then find the single one. This kind of counting need to use HashMap.  
*Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}
public int singleNumber(int[] A) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int i;
    for (i = 0; i < A.length; i++) {
        map.put(A[i], map.containsKey(A[i]) ? 2 : 1);
    }

    for (i = 0; i < A.length; i++) {
        if (map.get(A[i]) == 1) {
            break;
        }
    }

    return A[i];
}
{% endhighlight %}

**Solution 1**:  
Notice the word 'twice'. It is easy to remember the XOR, which has the features that A XOR A = 0, A XOR 0 = A. Whenever meeting the word 'twice', it's worth to give XOR a try. In this problem, you can simply XOR all the numbers, and the result is exactly the single one you want.  
*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

**Code**:  
{% highlight java %}
public class Solution {
    public int singleNumber(int[] A) {
        int result = A[0];
        for (int i = 1; i < A.length; i++)
            result ^= A[i];
        return result;
    }
}
{% endhighlight %}

