---
layout: post
title: Crack the LeetCode - Palindrome Number
---

{{ page.title }}
================

<p class="meta">11 March 2014 - Shanghai </p>

**Problem**:   
Determine whether an integer is a palindrome. Do this without extra space.

**Example**:   
INPUT: 123321  
OUTPUT: true 

**NOTE**:
Since the problem doesn't clarify whether negative numbers are consider as palindrome, you can discuss it with interviewers as open problem. But for this OJ, negatives numbers aren't palindrome.

**Solution 0**:  
You can just examine each pair of digit to check whether it's a palindrome.

*Time Complexity*:O(log(n))  
*Space Complexity*:O(1)  

{% highlight java %}  
public boolean isPalindrome(int x) {
    if (x < 0) {
        return false;
    }

    int len = 1, num = x;
    while ((num /= 10) != 0) {
        len++;
    }

    for (int i = 0; i < len/2; i++) {
        if (getDigitAt(x, i) != getDigitAt(x, len-1-i)) {
            return false;
        }
    }
    return true;
}

public int getDigitAt(int num, int idx) {
    while (idx-- > 0) {
        num /= 10;
    }
    return num % 10;
}
{% endhighlight %}
