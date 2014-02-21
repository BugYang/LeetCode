---
layout: post
title: Crack the LeetCode - Linked List Cycle
---

{{ page.title }}
================

<p class="meta">21 February 2014 - Shanghai </p>

**Problem**:  
Given a linked list, determine if it has a cycle in it.

**Example**:  
INPUT: {1, 2, 3, 1}  
OUTPUT: true   

**Solution 0**:  
Basically, you can count the node using HashMap or HashSet and find which node appear twice.  
*Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}
public boolean hasCycle(ListNode head) {
    HashSet<ListNode> set = new HashSet<ListNode>();
    while (head != null) {
        if (set.contains(head)) {
            return true;
        } else {
            set.add(head);
        }
        head = head.next;
    }
    return false;
}
{% endhighlight %}

**Solution 1**:  
A perfect solution is to use Floyd's Tortoise-Hare algorithm, which will use no extra space. The basic idea is to use two pointer and move them at different speeds: move one by 1 step and another by 2 steps. If there exists a cycle, they will definitely meet each other. Otherwise, the faster one will become null pointer.  
*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}
public boolean hasCycle(ListNode head) {
    ListNode tortoise = head, hare = head;
    do {
        hare = hare == null ? null : hare.next;
        hare = hare == null ? null : hare.next;
        if (hare == null) {
            return false;
        }
        tortoise = tortoise.next;
    } while (tortoise != hare);
    return true;
}
{% endhighlight %}

