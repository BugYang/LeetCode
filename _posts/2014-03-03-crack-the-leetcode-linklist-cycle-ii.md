---
layout: post
title: Crack the LeetCode - Linked List Cycle II
---

{{ page.title }}
================

<p class="meta">03 March 2014 - Shanghai </p>

**Problem**:  
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

**Example**:    
INPUT: {1,2,3,2}
OUTPUT: 2

**Solution 0**:  
This problem is almost same as its last version except the return value. So you can still use solutions before. The first is to use counting.

*Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}  
public ListNode detectCycle(ListNode head) {
    Set<ListNode> set = new HashSet<ListNode>();
    for (; head != null; head = head.next) {
        if (set.contains(head)) {
            return head;
        }
        set.add(head);
    }
    return null;
}
{% endhighlight %}

**Solution 1**:  

The second is to use Tortose-Hare algorithm.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
{% endhighlight %}

