---
layout: post
title: Crack the LeetCode - Sprial Matrix II
---

{{ page.title }}
================

<p class="meta">10 March 2014 - Shanghai </p>

**Problem**:   
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

**Example**:   
INPUT: 3    
OUTPUT: [[1,2,3],[8,9,4],[7,6,5]]

**Solution 0**:  
At the first glance, you may want to figure out the math formula to solve it. But actually, the generation of spiral matrix could be quite automatical, so you can simply generate it step by step.

*Time Complexity*:O(n^2)  
*Space Complexity*:O(n^2)  

{% highlight java %}  
public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    if (n == 0) {
        return result;
    }
    int x = 0, y = 0, i = 1;
    result[x][y] = i++;
    while (i <= n*n) {
        while (y+1 < n && result[x][y+1] == 0) {
            result[x][++y] = i++;
        }
        while (x+1 < n && result[x+1][y] == 0) {
            result[++x][y] = i++;
        }
        while (y-1 >= 0 && result[x][y-1] == 0) {
            result[x][--y] = i++;
        }
        while (x-1 >= 0 && result[x-1][y] == 0) {
            result[--x][y] = i++;
        }
    }
    return result;
}
{% endhighlight %}
