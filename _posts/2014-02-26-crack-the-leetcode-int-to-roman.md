---
layout: post
title: Crack the LeetCode - Integer to Roman
---

{{ page.title }}
================

<p class="meta">26 February 2014 - Shanghai </p>

**Problem**:  
Given an integer, convert it to a roman numeral.

**Example**:    
INPUT: 9  
OUTPUT: IX

**Solution 0**:  
This problem is similar to 'Roman to Integer' problem. So the key point is to understand the rules of Roman numerals. The algorithm below has one tricky point: it takes subtraction combinations as single digit so that it can avoid combine them manually.

*Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}  
private String[] digit = {"I", "IV", "V", "IX","X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
private int[] dec = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

public String intToRoman(int num) {
    String result = "";
    for (int i = digit.length-1; i >= 0 && num > 0; i--) {
        if (num < dec[i]) {
            continue;
        } else {
            for (int j = 0; j < num/dec[i]; j++) {
                result += digit[i];
            }
            num = num % dec[i];
        }
    }
    return result;
}
{% endhighlight %}
