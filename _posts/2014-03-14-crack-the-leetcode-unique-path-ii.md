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

**Solution 1**:  
Here is the recursive version.

*Time Complexity*:O(m*n)  
*Space Complexity*:O(m*n)  

{% highlight java %}  
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    Map<Integer, Integer> buf = new HashMap<Integer, Integer>();
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    return uniquePathHelper(obstacleGrid, m-1, n-1, buf);
}

public int getKey(int x, int y) {
    return x*1000 + y;
}

public int uniquePathHelper(int[][] grid, int x, int y, Map<Integer, Integer> buf) {
    int key = getKey(x, y);
    if (!buf.containsKey(key)) {
        int result = 0;
        if (grid[x][y] == 1) {
            result = 0;
        } else if (x == 0 && y == 0) {
            result = 1;
        } else {
            result += x == 0 ? 0 : uniquePathHelper(grid, x-1, y, buf);
            result += y == 0 ? 0 : uniquePathHelper(grid, x, y-1, buf);
        }
        buf.put(key, result);
    }
    return buf.get(key);
}
{% endhighlight %}
