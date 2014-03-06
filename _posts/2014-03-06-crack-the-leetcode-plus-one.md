---
layout: post
title: Crack the LeetCode - Plus One
---

{{ page.title }}
================

<p class="meta">05 March 2014 - Shanghai </p>

**Problem**:  
Given a non-negative number represented as an array of digits, plus one to the number. The digits are stored such that the most significant digit is at the head of the list.

**Example**:    
INPUT: [1,2]  
OUTPUT: [1,3]

**Solution 0**:  
It's only a easy big integer problem.

*Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}  
public int[] plusOne(int[] digits) {
    int[] result = new int[digits.length+1];
    int carry = 1;
    for (int i = digits.length-1; i >= 0; i--) {
        carry += digits[i];
        result[i+1] = carry % 10;
        carry /= 10;
    }

    if (carry != 0) {
        result[0] = carry;
        return result;
    } else {
        return Arrays.copyOfRange(result, 1, result.length);
    }
}
{% endhighlight %}
