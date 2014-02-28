---
layout: post
title: Crack the LeetCode - Single Number II
---

{{ page.title }}
================

<p class="meta">28 February 2014 - Shanghai </p>

**Problem**:  
Given an array of integers, every element appears three times except for one. Find that single one.

**Example**:    
INPUT: {1,1,1,2}
OUTPUT: 2 

**Solution 0**:  
You can still use the similar solution(counting) in single number problem.

    *Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}  
public int singleNumber(int[] A) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int i;
    for (i = 0; i < A.length; i++) {
        map.put(A[i], map.containsKey(A[i]) ? map.get(A[i])+1 : 1);
    }

    for (i = 0; i < A.length; i++) {
        if (map.get(A[i]) != 3) {
            break;
        }
    }
    return A[i];
}
{% endhighlight %}

**Solution 1**:  
A better solution need to make better use of 'three times'. In the problem single number i, we use XOR to remove the double appearance. So how to remove the triple appearance in this problem? The answer is MOD. With this key point, the solution is obvious.

    *Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int singleNumber(int[] A) {
    int result = 0;
    int[] bits = new int[32];
    for (int i : A) {
        for (int j = 0; j < 32; j++) {
            bits[j] += (result>>j & 1) + (i>>j & 1);
        }
        result += bits[i]%3 << i;
    }

    return result;
}
{% endhighlight %}
