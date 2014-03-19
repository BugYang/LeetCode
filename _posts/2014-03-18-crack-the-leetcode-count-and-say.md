---
layout: post
title: Crack the LeetCode - Count and Say
---

{{ page.title }}
================

<p class="meta">18 March 2014 - Shanghai </p>

**Problem**:   
Gnd-say sequence is the sequence of integers beginning as follows:  
1, 11, 21, 1211, 111221, ...  
1 is read off as "one 1" or 11.  
11 is read off as "two 1s" or 21.  
21 is read off as "one 2, then one 1" or 1211.  
Given an integer n, generate the nth sequence.  
Note: The sequence of integers will be represented as a string.iven a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

**Example**:   
INPUT:   
OUTPUT:   

**Solution 0**:  
Obviously, there is a simple recursive solution.

*Time Complexity*:O(?)  
*Space Complexity*:O(?)  

{% highlight java %}  
public String countAndSay(int n) {
    if (n == 1) {
        return "1";
    }

    String base = countAndSay(n-1), result="";
    int count = 1, len = base.length(), i;
    for (i = 1; i < len; i++) {
        if (base.charAt(i) == base.charAt(i-1)) {
            count++;
        } else {
            result += count;
            result += base.charAt(i-1);
            count = 1;
        }
    }
    if (count != 0) {
        result += count;
        result += base.charAt(i-1);
    }

    return result;
}
{% endhighlight %}
