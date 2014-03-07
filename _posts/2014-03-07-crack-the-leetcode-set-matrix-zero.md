---
layout: post
title: Crack the LeetCode - Set Matrix Zero
---

{{ page.title }}
================

<p class="meta">07 March 2014 - Shanghai </p>

**Problem**:  
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

**Example**:    
INPUT: [[0,1],[2,3]]  
OUTPUT: [[0,0],[0,3]]

**Solution 0**:  
If you make one copy of the matrix, you can just scan the copy and set the original matrix.

*Time Complexity*:O(mn)  
*Space Complexity*:O(mn)  

{% highlight java %}  
public void setZeroes_Omn(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] matrixCopy = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            matrixCopy[i][j] = matrix[i][j];
        }
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrixCopy[i][j] == 0) {
                for (int x = 0; x < m; x++) {
                    matrix[x][j] = 0;
                }
                for (int y = 0; y < n; y++) {
                    matrix[i][y] = 0;
                }
            }
        }
    }
}
{% endhighlight %}

**Solution 1**:  
Or you can just record which rows and columns should be set to 0, which takes much less space.

*Time Complexity*:O(mn)  
*Space Complexity*:O(m+n)  

{% highlight java %}  
public void setZeroes_Omplusn(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[] rows = new int[m], cols = new int[n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 0) {
                rows[i] = 1;
                cols[j] = 1;
            }
        }
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (rows[i] == 1 || cols[j] == 1) {
                matrix[i][j] = 0;
            }
        }
    }
}
{% endhighlight %}

**Solution 2**:  
The best solution here is a little bit tricky. Notice that when you find one element is 0, all its row and column should be zero, which you can use as the O(m+n) space as you need in the above solution.

*Time Complexity*:O(mn)  
*Space Complexity*:O(1)  

{% highlight java %}  
public void setZeroes_O1(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int row = -1, col = -1;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 0) {
                if (row == -1) {
                    row = i;
                    col = j;
                } else {
                    matrix[i][col] = 0;
                    matrix[row][j] = 0;
                }
            }
        }
    }

    if (row == -1) {
        return;
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if ((i != row && matrix[i][col] == 0) || (j != col && matrix[row][j] == 0)) {
                matrix[i][j] = 0;
            }
        }
    }

    for (int i = 0; i < m; i++) {
        matrix[i][col] = 0;
    }
    for (int j = 0; j < n; j++) {
        matrix[row][j] = 0;
    }
}
{% endhighlight %}
