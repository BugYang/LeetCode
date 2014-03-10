---
layout: post
title: Crack the LeetCode - Remove Nth Node From End of List
---

{{ page.title }}
================

<p class="meta">10 March 2014 - Shanghai </p>

**Problem**:   
Given a linked list, remove the nth node from the end of list and return its head.

**Example**:   
INPUT: 1->2->3->4->5, 2    
OUTPUT: 1->2->3->5

**Solution 0**:  
Intuitively, you can solve it using two passes. The first pass is to find the list length, so you can locate the wanted node from the begining. The second pass is to find the specifed node. A corner case is the specified node is the head, so it need extra effort to remove it.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}
public ListNode removeNthFromEnd_2pass(ListNode head, int n) {
    int len = 1;
    ListNode cur = head;
    while (cur.next != null) {
        cur = cur.next;
        len++;
    }
    cur = head;
    if (len > n) {
        while (len > n+1) {
            cur = cur.next;
            len--;
        }
        cur.next = cur.next.next;
    } else {
        head = head.next;
    }
    return head;
}  
{% endhighlight %}

**Solution 1**:  
Or you can solve it using one pass. In the only pass, you have to check whether each node is the wanted node. You still have to handle the corner case.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public ListNode removeNthFromEnd_1pass(ListNode head, int n) {
    ListNode last = null, cur = head;
    while (true) {
        ListNode tmp = cur;
        for (int i = 0; i < n; i++) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            break;
        }
        last = cur;
        cur = cur.next;
    }

    if (last == null) {
        head = head.next;
    } else {
        last.next = cur.next;
    }
    return head;
}
{% endhighlight %}
