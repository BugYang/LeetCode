---
layout: post
title: Crack the LeetCode - Unique Paths
---

{{ page.title }}
================

<p class="meta">05 March 2014 - Shanghai </p>

**Problem**:  
A robot is located at the top-left corner of a m x n grid. The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid. How many possible unique paths are there?

**Example**:    
INPUT: 2,1  
OUTPUT: 1  

**Solution 0**:  
It's a typical combination algebra problem, and its solution is C(m-1, m+n-2). The only pitfall is you may meet integer overflow when computing the combination. Actually, the problem itself has some problem because its result may be greater than 2^31-1. However, since the function prototype specifies the return value type is integer, you could make some assumptions based on this. In my solution, I use long to store intermediate result, and I do division as soon as possible in order to avoid overflow.

*Time Complexity*:O(m+n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int uniquePaths(int m, int n) {
    long result = 1, x = 2;
    for (int i = m; i <= m+n-2; i++) {
        long a = result, b = i;
        result = a * b;
        while (result%x == 0 && x < n) {
            result /= x++;
        }
    }
    return (int)result;
}
{% endhighlight %}

**Solution 1**:  
The recursive solution is also obvious, but if you simply write a recursive function without other optimizations, you may meet TLE because you need to calculate same sub-problems for many times. So you can use memorization to avoid duplicate recursion.

*Time Complexity*:O(m+n)  
*Space Complexity*:O(m+n)  

{% highlight java %}  
public int uniquePaths_recur(int m, int n) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(genKey(1,1), 1);
    return uniquePathsHelper(m, n, map);
}

public int genKey(int m, int n) {
    return m * 1000 + n;
}

public int uniquePathsHelper(int m, int n, HashMap<Integer, Integer> map) {
    int key = genKey(m, n);
    if (map.containsKey(key)) {
        return map.get(key);
    }
    int result = 0;
    result += m > 1 ? uniquePathsHelper(m-1, n, map) : 0;
    result += n > 1 ? uniquePathsHelper(m, n-1, map) : 0;
    map.put(key, result);
    return result;
}
{% endhighlight %}


**Solution 2**:  
Or you can also use dynamic programming to solve this problem.

*Time Complexity*:O(m+n)  
*Space Complexity*:O(m*n) (it can be optimized to O(n))

{% highlight java %}  
public int uniquePaths_DP(int m, int n) {
    int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i * j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }
        return result[m-1][n-1];
    }
{% endhighlight %}
