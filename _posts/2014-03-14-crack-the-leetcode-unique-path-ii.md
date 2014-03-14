---
layout: post
title: Crack the LeetCode - Unique Paths II
---

{{ page.title }}
================

<p class="meta">13 March 2014 - Shanghai </p>

**Problem**:   
Follow up for "Unique Paths": Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.

**Example**:   
INPUT: [[0,0,0],[0,1,0],[0,0,0]]   
OUTPUT: 2

**Solution 0**:  
It's easy to add some exception case handling to original solutions. Here is the DP version.

*Time Complexity*:O(m*n)  
*Space Complexity*:O(n)  

{% highlight java %}  
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[] cnt = new int[n];
    cnt[0] = 1;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[i][j] == 1) {
                cnt[j] = 0;
            } else if (j-1 >= 0) {
                cnt[j] += cnt[j-1];
            }
        }
    }
    return cnt[n-1];
}
{% endhighlight %}
