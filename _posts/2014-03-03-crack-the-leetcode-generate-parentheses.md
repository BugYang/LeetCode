---
layout: post
title: Crack the LeetCode - Generate Parentheses
---

{{ page.title }}
================

<p class="meta">03 March 2014 - Shanghai </p>

**Problem**:  
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

**Example**:    
INPUT: 3  
OUTPUT: "((()))", "(()())", "(())()", "()(())", "()()()"

**Solution 0**:  
It is easy to solve using recursive function.

*Time Complexity*:O(?)  
*Space Complexity*:O(?)  

{% highlight java %}  
{% endhighlight %}

**Solution 1**:  
The algorithm above need 2 passes, which is actuall unnecessay. Consider such scenario: in the array A, A[0:p0] contain 0, A[p1:p2] contain 1, A[p2:] contain 2, how to add one more element which may be 0,1 or 2? After figuring this out, you can surely give a one-pass solution.

*Time Complexity*:O(1)  
*Space Complexity*:O(n)  

{% highlight java %}  
public ArrayList<String> generateParenthesis(int n) {
    return genParenHelper(n, n, 0);
}

public ArrayList<String> genParenHelper(int numLeftParen, int numRightParen, int numRightAllowed) {
    ArrayList<String> result = new ArrayList<String>();
    if (numLeftParen > 0) {
        String pre = "(";
        ArrayList<String> posts = genParenHelper(numLeftParen - 1, numRightParen, numRightAllowed+1);
        for (String post : posts) {
            result.add(pre+post);
        }
    }
    if (numRightParen > 0 && numRightAllowed > 0) {
        String pre = ")";
        ArrayList<String> posts = genParenHelper(numLeftParen, numRightParen-1, numRightAllowed-1);
        for (String post : posts) {
            result.add(pre+post);
        }
    }
    if (numLeftParen + numRightParen + numRightAllowed == 0) {
        result.add("");
    }
    return result;
}
{% endhighlight %}

