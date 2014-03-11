---
layout: post
title: Crack the LeetCode - Populating Next Right Pointers in Each Node II
---

{{ page.title }}
================

<p class="meta">11 March 2014 - Shanghai </p>

**Problem**:   
Follow up for problem "Populating Next Right Pointers in Each Node". What if the given tree could be any binary tree? Would your previous solution still work? You may only use constant extra space.

**Example**:   
INPUT: {1,2,3,4,5,#,7}   
OUTPUT: {1,#,2,3,#,4,5,7,#}

**Solution 0**:  
The keypoint is still to make use of parents' next to find children's next. But it becomes more difficult to find children's next since the tree may be not a perfect binary tree. And also, in original problem, pre-order traversal is ok. But here, you have to use level-order traversal, otherwise you may find wrong next pointer since the right part is not ready.

*Time Complexity*:O(V)  
*Space Complexity*:O(1)  

{% highlight java %}  
public void connect(TreeLinkNode root) {
    Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    if (root != null) {
        queue.add(root);
    }
    while (queue.peek() != null) {
        TreeLinkNode node = queue.poll();
        connectNode(node);
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}

public void connectNode(TreeLinkNode root) {
    if (root == null || root.left == null && root.right == null) {
        return;
    }

    TreeLinkNode cur = root, next = null;
    while (true) {
        if (cur.next == null) {
            break;
        }
        cur = cur.next;
        if (cur.left != null) {
            next = cur.left;
            break;
        }
        if (cur.right != null) {
            next = cur.right;
            break;
        }
    }

    if (root.right == null) {
        root.left.next = next;
    } else {
        root.right.next = next;
        if (root.left != null) {
            root.left.next = root.right;
        }
    }
}
{% endhighlight %}
