---
layout: post
title: Crack the LeetCode - Maximum Subarray
---

{{ page.title }}
================

<p class="meta">25 February 2014 - Shanghai </p>

**Problem**:  
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

**Example**:    
INPUT: [-2,1,-3,4,-1,2,1,-5,4]  
OUTPUT: 6 (sum of [4,-1,2,1]) 

**NOTE**:  
Actually, I've met this problem before and failed to give a solution. Then I found [this slides](http://www.cse.ust.hk/faculty/golin/COMP271Sp03/Notes/L02.pdf) really useful. 

**Solution 0**:  
The first solution is the O(n) algorithm in the slides. Even the idea is straightfoward: just traverse the array, keep the max_sum_ending_here by keeping Tmax and Tmin and find the max_sum_so_far, which is the final solution, there is a tricky point. The algorithm is iterative, and each iteration need a base iteration. So you have to handle the first iteration manually, which means you initialize T, Tmin, Tmax approperly.

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int maxSubArray(int[] A) {
    int T = A[0], minT = Math.min(0, A[0]), max = A[0];
    for (int i = 1; i < A.length; i++) {
        T += A[i];
        max = T-minT > max ? T-minT : max;
        minT = T < minT ? T : minT;
    }
    return max;
}
{% endhighlight %}

**Solution 1**:  
The second solution is another O(n) algorithm similar with the last one. The only difference is how to keep the max_sum_ending_here. Assuming you have the max_sum ending in A[n-1], you can easily get max_sum ending in A[n]. But you still should take care of the tricky point above.  

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int maxSubArray(int[] A) {
    int sum = A[0], max = A[0];
    for (int i = 1;i < A.length; i++) {
        sum = A[i] + (sum < 0 ? 0 : sum);
        max = sum > max ? sum : max;
    }
    return max;
}
{% endhighlight %}

**Solution 2**:  
The recursive solution is well explained in the slides above, so I only paste my code here.

*Time Complexity*:O(nlogn)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int maxSubArray(int[] A) {
    if (A.length == 1) {
        return A[0];
    }

    int div = A.length/2;
    int lMax = maxSubArray(Arrays.copyOfRange(A, 0, div));
    int rMax = div+1 < A.length ? maxSubArray(Arrays.copyOfRange(A, div+1, A.length)) : lMax;
    int mMax = A[div];
    int sum = 0;
    for (int i = div; i >= 0; i--) {
        sum += A[i];
        mMax = Math.max(sum, mMax);
    }
    sum = mMax;
    for (int i = div + 1; i < A.length; i++) {
        sum += A[i];
        mMax = Math.max(sum, mMax);
    }

    return Math.max(Math.max(lMax, rMax), mMax);
}
{% endhighlight %}
