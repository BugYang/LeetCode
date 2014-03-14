---
layout: post
title: Crack the LeetCode - Jump Game
---

{{ page.title }}
================

<p class="meta">13 March 2014 - Shanghai </p>

**Problem**:   
Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Determine if you are able to reach the last index.

**Example**:   
INPUT: [2,3,1,1,4]  
OUTPUT: true

**Solution 0**:  
The first point is you really understand the problem. A[i] means you can but not necessary jump at most A[i] steps. After understanding this, it's easy to figure out a recursive solution. Then the second key point is how to rerduce its time complexity. There are many duplicate recursive call comsuming lots of time, so you can memorize it using a map.

*Time Complexity*:O(?)  
*Space Complexity*:O(?)  

{% highlight java %}  
public boolean canJump(int[] A) {
    Map<Integer, Boolean> buf = new HashMap<Integer, Boolean>();
    return canJumpHelper(A, 0, buf);
}

public boolean canJumpHelper(int[] A, int cur, Map<Integer, Boolean> buf) {
    if (cur >= A.length-1) {
        return true;
    }
    for (int i = A[cur]; i > 0; i--) {
        if (!buf.containsKey(i)) {
            buf.put(i, canJumpHelper(A, cur+i, buf));
        }
        return buf.get(i);
    }
    return false;
}
{% endhighlight %}

**Solution 1**:  
If you think this problem as how far could be reached from A[0], things become much easier. You can just traverse all places you can reach and see if you can go further. Finally, you can check whether you can reach A[length-1].

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public boolean canJump(int[] A) {
    int max = A[0];
    for (int i = 0; i <= max && i < A.length; i++) {
        max = Math.max(max, i+A[i]);
    }
    return max >= A.length-1;
}
{% endhighlight %}
