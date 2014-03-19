---
layout: post
title: Crack the LeetCode - Convert Sorted List To Binary Search Tree
---

{{ page.title }}
================

<p class="meta">17 March 2014 - Shanghai </p>

**Problem**:   
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

**Example**:   
INPUT:   
OUTPUT:   

**Solution 0**:  
Compared with the array-based version, the only difference is you can't access to the middle node in O(1) time. But you can still calculate the length and get the "length/2"th node, which is the middle.

*Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}  
public TreeNode sortedListToBST(ListNode head) {
    ListNode cur = head;
    int len = 0;
    while (cur != null) {
        len++;
        cur = cur.next;
    }
    return sortedListToBSTHelper(head, len);
}

public TreeNode sortedListToBSTHelper(ListNode head, int len) {
    if (len < 1 || head == null) {
        return null;
    }

    ListNode cur = head;
    int idx = len/2;
    for (int i = 0; i < idx; i++) {
        cur = cur.next;
    }

    TreeNode root = new TreeNode(cur.val);
    root.left = sortedListToBSTHelper(head, idx);
    root.right = sortedListToBSTHelper(cur.next, len-idx-1);
    return root;
}
{% endhighlight %}
