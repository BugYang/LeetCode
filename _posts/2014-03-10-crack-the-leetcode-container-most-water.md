---
layout: post
title: Crack the LeetCode - Container With Most Water
---

{{ page.title }}
================

<p class="meta">10 March 2014 - Shanghai </p>

**Problem**:  
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

**Example**:    
INPUT: {1,3,4,2}  
OUTPUT: 4

**NOTE**:  
Intuitively, you would use brute-force method to solve it, but you would suryly meet TLE. I failed to find better solution, so I googled the solution. Then I found there are two better solution. Both solutions base on the observation that the volume of container depend on the width and the minimum line, and if you know one of the lines, you know the upper bound of the minimum line. 

**Solution 0**:  
The first one is to calculate the minimum possible index to reduce the searching space. The first one could pass the OJ before, but now it fails to do so.

*Time Complexity*:O(n^2)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int maxArea(int[] height) {
    int max = 0, i = 0, j = height.length-1;
    for (int i = 0; i < height.length; i++) {
        if (height[i] == 0) {
            continue;
        }
        for (int j = i+max/height[i]; j < height.length; j++) {
            int size = Math.min(height[i], height[j]) * (j-i);
            max = size > max ? size : max;
        }
    }
    return max;
}
{% endhighlight %}, 

**Solution 1**:  
The second one is a much better and more tricky solution.  

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int maxArea(int[] height) {
    int max = 0, i = 0, j = height.length-1;
    while (i < j) {
        int size = Math.min(height[i], height[j]) * (j-i);
        max = size > max ? size : max;
        if (height[i] > height[j]) {
            j--;
        } else {
            i++;
        }
    }
    return max;
}
{% endhighlight %}, 
