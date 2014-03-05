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
The second is to use Tortose-Hare algorithm but need a slight modification since the node where the two meet is not guaranteed to be the loop head. The trick here need some tough thinking. Let's assume there is a nodes before the loop and T nodes in the loop, and the first meeting point M is b nodes ahead of loop head O. So using a+b steps, tortoise and hare move to M from list head A; using another a+b steps, hare move to M from M. After then, it will take a steps for tortoise to move to O from M since OM=b and MM=a+b. And also, it will take a steps for another tortoise to move to O from A since OA=a. Then the solution is obvious: after tortoise and hare meeting each other, let another tortoise begin from A, original tortoise begin from M, then their first meeting point will be O, the head of loop.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public ListNode detectCycle(ListNode head) {
    ListNode tortoise = head, hare = head;
    do {
        hare = hare == null ? null : hare.next;
        hare = hare == null ? null : hare.next;
        if (hare == null) {
            return null;
        }
        tortoise = tortoise.next;
    } while (hare != tortoise);

    hare = head;
    while (hare != tortoise) {
        hare = hare.next;
        tortoise = tortoise.next;
    }

    return hare;
}
{% endhighlight %}

