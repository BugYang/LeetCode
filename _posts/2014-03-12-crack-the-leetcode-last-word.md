---
layout: post
title: Crack the LeetCode - Length of Last Word
---

{{ page.title }}
================

<p class="meta">12 March 2014 - Shanghai </p>

**Problem**:   
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string. If the last word does not exist, return 0. Note: A word is defined as a character sequence consists of non-space characters only.

**Example**:   
INPUT: "hello world"  
OUTPUT: 5

**Solution 0**:  
You can just traverse the string from the end to the beginning and find the right and left bounders of the last word.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int lengthOfLastWord(String s) {
    int r = s.length() - 1;
    while (r >= 0 && s.charAt(r) == ' ') {
        r--;
    }
    int l = r;
    while (l >= 0 && s.charAt(l) != ' ') {
        l--;
    }
    return r-l;
}
{% endhighlight %}
