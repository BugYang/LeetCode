---
layout: post
title: Crack the LeetCode - Best Time to Buy and Sell Stock
---

{{ page.title }}
================

<p class="meta">01 March 2014 - Shanghai </p>

**Problem**:  
Say you have an array for which the ith element is the price of a given stock on day i. If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

**Example**:    
INPUT: [1,4,2,6] 
OUTPUT: 5

**Solution 0**:  
If you have finished the maximum continuous subarray problem, you may find this problem is just a subproblem of that. 

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
        return 0;
    }
    int min = prices[0], profit = 0;
    for (int i = 1; i < prices.length; i++) {
        profit = prices[i] - min > profit ? prices[i] - min : profit;
        min = prices[i] < min ? prices[i] : min;
    }
    return profit;
}
{% endhighlight %}
