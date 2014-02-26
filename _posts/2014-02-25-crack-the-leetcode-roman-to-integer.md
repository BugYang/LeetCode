---
layout: post
title: Crack the LeetCode - Roman to Integer
---

{{ page.title }}
================

<p class="meta">25 February 2014 - Shanghai </p>

**Problem**:  
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

**Example**:    
INPUT: V  
OUTPUT: 5  

**Solution 0**:  
First of all, you must understand [the rules of roman number](http://en.wikipedia.org/wiki/Roman_numerals). After getting a good sense of it, you can get a straightforward solution: just traverse the digit, if it is less than the next one, you have to combine them by subtraction; otherwise, you can take it as a independent digit.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
private String digit = "IVXLCDM";
private int[] dec = {1, 5, 10, 50, 100, 500, 1000};

public int romanToInt(String s) {
    int result = 0, len = s.length();

    for (int i = 0; i < len; i++) {
        int cur = dec[digit.indexOf(s.charAt(i))];
        int next = i+1 < len ? dec[digit.indexOf(s.charAt(i+1))] : cur;
        if (cur < next) {
            result += next-cur;
            i++;
        } else {
            result += cur;
        }
    }

    return result;
}
{% endhighlight %}
