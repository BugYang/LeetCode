---
layout: post
title: Crack the LeetCode - Remove Duplicates from Sorted List 
---

{{ page.title }}
================

<p class="meta">24 February 2014 - Shanghai </p>

**Problem**:  
Given a sorted linked list, delete all duplicates such that each element appear only once.

**Example**:    
INPUT: 1->1->2  
OUTPUT: 1->2  
INPUT: 1->1->2->3->3  
OUTPUT: 1->2->3  

**Solution 0**:  
The solution is obvious. You can just traverse the list and change the next pointer if node's next is a duplicate.  
*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head;
    while (cur != null && cur.next != null) {
        if (cur.val == cur.next.val) {
            cur.next = cur.next.next;
        } else {
            cur = cur.next;
        }
    }
    return head;
}
{% endhighlight %}
