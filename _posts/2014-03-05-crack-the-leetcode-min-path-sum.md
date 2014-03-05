---
layout: post
title: Crack the LeetCode - Minimum Path Sum
---

{{ page.title }}
================

<p class="meta">05 March 2014 - Shanghai </p>

**Problem**:  
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path. You can only move either down or right at any point in time.

**Example**:    
INPUT: [[1,3,1],[1,5,1],[4,2,1]]  
OUTPUT: 7  

**Solution 0**:  
It's a typical DP problem. Once you grab the rule that minSum(m,n) = min(minSum(m-1,n), minSum(m,n-1)), you can easily give this solution: use a table to record minSum(m,n), fill up the table iteratively and the bottom right element will be the result.

*Time Complexity*:O(m*n)  
*Space Complexity*:O(m*n)  

{% highlight java %}  
public int minPathSum_DP_Omn(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) {
                result[i][j] = grid[i][j];
            } else if (i == 0) {
                result[i][j] = result[i][j-1] + grid[i][j];
            } else if (j == 0) {
                result[i][j] = result[i-1][j] + grid[i][j];
            } else {
                result[i][j] = Math.min(result[i-1][j], result[i][j-1]) + grid[i][j];
            }
        }
    }
    return result[m-1][n-1];
}
{% endhighlight %}

**Solution 1**:  
If you have more observation, you can give a less memory-comsuming DP solution. Notice that any table entry only depend on its left column and up row, so you can just use one row to record the result, which only take O(n) space.

*Time Complexity*:O(m*n)  
*Space Complexity*:O(n)  

{% highlight java %}  
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[] result = new int[n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) {
                result[j] = grid[i][j];
            } else if (i == 0) {
                result[j] = result[j-1] + grid[i][j];
            } else if (j == 0) {
                result[j] = result[j] + grid[i][j];
            } else {
                result[j] = Math.min(result[j], result[j-1]) + grid[i][j];
            }
        }
    }
    return result[n-1];
}
{% endhighlight %}
