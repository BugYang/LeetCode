---
layout: post
title: Crack the LeetCode - Longest Common Prefix
---

{{ page.title }}
================

<p class="meta">14 March 2014 - Shanghai </p>

**Problem**:   
Write a function to find the longest common prefix string amongst an array of strings.

**Example**:   
INPUT: ["aca", "baa"]  
OUTPUT: ""

**Solution 0**:  
The problem is quite simple, and you just need be careful of pitfalls, such as empty set of strings. 

*Time Complexity*:O(?)  
*Space Complexity*:O(1)  

{% highlight java %}  
public String longestCommonPrefix(String[] strs) {
    String result = "";
    if (strs.length == 0) {
        return result;
    }
    for (int i = 0; i < strs[0].length(); i++) {
        char ch = strs[0].charAt(i);
        boolean isPrefix = true;
        for (int j = 1; j < strs.length; j++) {
            if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                isPrefix = false;
                break;
            }
        }
        if (!isPrefix) {
            break;
        }
        result += ch;
    }
    return result;
}
{% endhighlight %}
