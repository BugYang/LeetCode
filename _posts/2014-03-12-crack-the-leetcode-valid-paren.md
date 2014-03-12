---
layout: post
title: Crack the LeetCode - Valid Parentheses
---

{{ page.title }}
================

<p class="meta">12 March 2014 - Shanghai </p>

**Problem**:   
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

**Example**:   
INPUT: ()[]{}  
OUTPUT: true 

**Solution 0**:  
You can use stack solve this problem without effort. But be careful of the corner cases such as empty stack!

*Time Complexity*:O(n)  
*Space Complexity*:O(n)  

{% highlight java %}  
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
        char cur = s.charAt(i);
        if (cur == '(' || cur == '[' || cur == '{') {
            stack.push(cur);
        } else {
            if (stack.empty()) {
                return false;
            }
            char last = stack.pop();
            if (last == '(' && cur != ')' ||
                    last == '[' && cur != ']' ||
                    last == '{' && cur != '}') {
                return false;
            }
        }
    }
    return stack.empty();
}
{% endhighlight %}
