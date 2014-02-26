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
First of all, you must understand [the rules of roman number](http://en.wikipedia.org/wiki/Roman_numerals). The complex part of rules is how to combine each digit and when to decide a combination should be part of result since there may be many digits combining as one. So you can use two steps counting: the first step is to combine the digit temporarily and the second step is to count the final combinations as result. Another key point is each time you meet a digit different from the last one, you should commit temporary combination to the final result. 

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
private String digit = "IVXLCDM";
private int[] dec = {1, 5, 10, 50, 100, 500, 1000};

public int romanToInt(String s) {
    int result = 0, len = s.length();
    int last = dec[digit.indexOf(s.charAt(0))], cur;
    int accumu = last;

    for (int i = 1; i < len; i++) {
        cur = dec[digit.indexOf(s.charAt(i))];
        if (last == cur) {
            accumu += cur;
        } else {
            result += last < cur ? cur-accumu : accumu;
            accumu = last < cur ? 0 : cur;
        }
        last = cur;
    }
    result += accumu;

    return result;
}
{% endhighlight %}
