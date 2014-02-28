---
layout: post
title: Crack the LeetCode - Swap Nodes in Pairs
---

{{ page.title }}
================

<p class="meta">28 February 2014 - Shanghai </p>

**Problem**:  
Given a linked list, swap every two adjacent nodes and return its head. Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

**Example**:    
INPUT: [1,2,3,4]  
OUTPUT: [2,1,4,3]

**Solution 0**:  
The solution is almost obvious...

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public ListNode swapPairs(ListNode head) {
    ListNode cur = head;
    while (cur != null && cur.next != null) {
        int t = cur.next.val;
        cur.next.val = cur.val;
        cur.val = t;
        cur = cur.next.next;
    }
    return head;
}
{% endhighlight %}
