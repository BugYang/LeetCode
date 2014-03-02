---
layout: post
title: Crack the LeetCode - Gray Code
---

{{ page.title }}
================

<p class="meta">01 March 2014 - Shanghai </p>

**Problem**:  
The gray code is a binary numeral system where two successive values differ in only one bit. Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0. Note, for a given n, a gray code sequence is not uniquely defined.

**Example**:    
INPUT: 2  
OUTPUT: [0,1,3,2]

**Solution 0**:  
This problem is a little bit challenging. But if you can't figure out a nice solution, you can still solve it using the most basic method. Notice you just have to 'sort' 0~2^n!

*Time Complexity*:O(2^n)  
*Space Complexity*:O(2^n)  

{% highlight java %}  
public boolean oneBitDiff(int a, int b) {
    int c = a^b, cnt = 0;
    while (c > 0) {
        cnt += c & 1;
        c = c >> 1;
    }
    return cnt == 1;
}

public ArrayList<Integer> grayCode(int n) {
    int pow = 1;
    for (int i = 0; i < n; i++) {
        pow *= 2;
    }

    int[] seq = new int[pow];
    for (int i = 0; i < pow; i++) {
        seq[i] = i;
    }

    for (int i = 0; i < pow-1; i++) {
        if (oneBitDiff(seq[i], seq[i+1])) {
            continue;
        }
        for (int j = i+2; j < pow; j++) {
            if (oneBitDiff(seq[i], seq[j])) {
                int t = seq[i+1];
                seq[i+1] = seq[j];
                seq[j] = t;
                break;
            }
        }
    }

    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i : seq) {
        result.add(i);
    }
    return result;
}
{% endhighlight %}

**Solution 1**:  
If you can relate the gray code with binary tree, there is much higher possibility to find a perfect solution, because that's how I find it:-) Notice this tree: take zero as the root, for each node, its left child get an additional 0, and its right child get an additional 1. Let's consider the nodes in the same level. So for two continuous nodes, if they have the same parent, they have only the last bit different. Otherwise, they have two bit different: one is the last bit, the other is the different bit of they parents. 

In the second case, if we make their last bit the saeme, so if we can reduce the number of difference to one, we get the solution. Since it's hard to change parents' differnent bit, we can change the last bit: just append 1,0 instead of 0,1 to the second node and the one after it. Now the sequence is 00,01,11,10. So you can get the solution: we can generate the node by appending 0,1 and 1,0 alternately. So for any two continuous node in the same order, if they have the same parent, they stil have the last bit different; otherwise they have only one different bit from their parents.

*Time Complexity*:O(2^n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public ArrayList<Integer> grayCode(int n) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(0);
    int count = 1, t, t0, t1;
    while (n-- > 0) {
        for (int i = 0; i < count; i++) {
            t = queue.remove();
            t0 = t << 1 | (i%2 == 0 ? 0 : 1);
            t1 = t << 1 | (i%2 == 0 ? 1 : 0);
            queue.add(t0);
            queue.add(t1);
        }
        count *= 2;
    }

    return new ArrayList<Integer>(queue);
}
{% endhighlight %}
