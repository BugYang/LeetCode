---
layout: post
title: Crack the LeetCode - Rotate Image 
---

{{ page.title }}
================

<p class="meta">02 March 2014 - Shanghai </p>

**Problem**:  
You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).

**Example**:    
INPUT: [[1,2], [3,4]]  
OUTPUT: [[3,1],[4,2]]

**Solution 0**:  
This is really a math problem. So you can make a copy of original matrix, calculate new indexes for each element using linear algebra and set new value of matrix elements.

*Time Complexity*:O(n^2)  
*Space Complexity*:O(n^2)  

{% highlight java %}  
public void rotate(int[][] matrix) {
    int[][] result = new int[matrix.length][matrix.length];
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
            result[i][j] = matrix[i][j];
        }
    }
    double origin = (matrix.length - 1.0) / 2;
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
            int x = (int)(j + 0.5);
            int y = (int)(2 * origin - i + 0.5);
            matrix[x][y] = result[i][j];
        }
    }
}
{% endhighlight %}
