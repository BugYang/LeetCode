---
layout: post
title: Crack the LeetCode - Best Time to Buy and Sell Stock II 
---

{{ page.title }}
================

<p class="meta">20 February 2014 - Shanghai </p>

**Problem**:  
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).Say you have an array for which the ith element is the price of a given stock on day i.

**Example**:  
INPUT: {3, 1, 5}  
OUTPUT: 4   

**Solution 0**:  
After understanding the problem, the solution is obvious. I don't understand why there is such an easy problem.  

*Time Complexity*:O(n)  
*Space Complexity*:O(1)  

{% highlight java %}
public int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
        if (prices[i] < prices[i+1]) {
            profit += prices[i+1] - prices[i];
        }
    }
    return profit;
}
{% endhighlight %}

