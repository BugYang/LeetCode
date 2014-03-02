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
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][matrix.length-1-i] = result[i][j];
        }
    }
}
{% endhighlight %}

**Solution 1**:  
Actually, you can avoid using another matrix if using some tricks. Notice that for any node, if you rotate it 4 times, you will be back to it. So we can select some starting node as bases, rotate the whole matrix and not use extra space. The only difficulty here is to figure out which points as bases.

*Time Complexity*:O(n^2)  
*Space Complexity*:O(1)  

{% highlight java %}  
public void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length/2; i++) {
        for (int j = i; j < matrix.length - i - 1; j++) {
            int x = i, y = j, cur = matrix[x][y];
            for (int k = 0; k < 4; k++) {
                int t = matrix[y][matrix.length-1-x];
                matrix[y][matrix.length-1-x] = cur;
                cur = t;
                int x1 = y, y1 = matrix.length-1-x;
                x = x1; y = y1;
            }
        }
    }
}
{% endhighlight %}
