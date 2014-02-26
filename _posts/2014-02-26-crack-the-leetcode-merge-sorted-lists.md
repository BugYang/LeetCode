---
layout: post
title: Crack the LeetCode - Merge Two Sorted Lists
---

{{ page.title }}
================

<p class="meta">26 February 2014 - Shanghai </p>

**Problem**:  
Merge two sorted linked lists and return it as a new list. The new list should be made by spliciing together the nodes of the first two lists.

**Example**:    
INPUT: [1,3] [2]  
OUTPUT: [1,2,3]

**Solution 0**:  
The solution is straightfoward: each time you choose a node from l1 or l2 with larger val and append it to the new list. But you should be careful about the null pointer error.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = null, cur = null, tmp, cur1, cur2;
    while (l1 != null || l2 != null) {
        cur1 = l1 != null ? l1 : l2;
        cur2 = l2 != null ? l2 : l1;
        tmp = cur1.val < cur2.val ? cur1 : cur2;

        if (head == null) {
            cur = head = tmp;
        } else {
            cur = cur.next = tmp;
        }

        l1 = tmp == l1 ? l1.next : l1;
        l2 = tmp == l2 ? l2.next : l2;
    }
    return head;
}
{% endhighlight %}
