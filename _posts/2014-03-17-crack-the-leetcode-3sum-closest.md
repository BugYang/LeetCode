---
layout: post
title: Crack the LeetCode - 3Sum Closest
---

{{ page.title }}
================

<p class="meta">17 March 2014 - Shanghai </p>

**Problem**:   
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

**Example**:   
INPUT:  {-1 2 1 -4}, 1  
OUTPUT:  2 {-1 + 2 + 1 = 2}

**Solution 0**:  
The most intuitive solution is to use brute-force method, which take O(n^3) time and get TLE for sure. Actually, I failed to reduce it at the first time. After reading [this article](http://tech-wonderland.net/blog/summary-of-ksum-problems.html), I got the O(n^2) solution. This solution is quite similar to the problem "Container With Most Water". When you search a pair of array elements that achieve some optimal properties, you can search the i, j simultaneously by making them move from the beginning or end until they meet, which take only O(n) time instead of O(n^2) of normal brute-force method.

*Time Complexity*:O(n^2)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int threeSumClosest(int[] num, int target) {
    int[] numCopy = Arrays.copyOf(num, num.length);
    Arrays.sort(numCopy);
    int result = numCopy[0] + numCopy[1] + numCopy[2];
    for (int i = 0; i < numCopy.length-2; i++) {
        int closest = numCopy[i]+ twoSumClosest(target-numCopy[i], numCopy, i+1, numCopy.length-1);
        if (Math.abs(closest-target) < Math.abs(result-target)) {
            result = closest;
        }
    }
    return result;
}

public int twoSumClosest(int target, int[] num, int begin, int end) {
    int result = num[begin] + num[end];

    while (begin < end) {
        int closest = num[begin]+num[end];
        if (Math.abs(closest-target) < Math.abs(result-target)) {
            result = num[begin] + num[end];
        }

        if (closest < target) {
            begin++;
        } else if (closest > target) {
            end--;
        } else {
            break;
        }
    }

    return result;
}
{% endhighlight %}
