---
layout: post
title: Crack the LeetCode - Combinations
---

{{ page.title }}
================

<p class="meta">10 March 2014 - Shanghai </p>

**Problem**:   
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

**Example**:   
INPUT: n=4, k=2   
OUTPUT: [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]

**Solution 0**:  
This problem can be solved by simple recursion.

*Time Complexity*:O(?)  
*Space Complexity*:O(?)  

{% highlight java %}  
public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    return combineHelper(n, k, 1);
}

public ArrayList<ArrayList<Integer>> combineHelper(int n, int k, int cur) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    if (k == 0) {
        result.add(list);
    } else if (n-cur+1 == k) {
        for (int i = cur; i <= n; i++) {
            list.add(i);
        }
        result.add(list);
    } else {
        result.addAll(combineHelper(n, k, cur+1));
        ArrayList<ArrayList<Integer>> lists = combineHelper(n, k-1, cur+1);
        for (int i = 0; i < lists.size(); i++) {
            lists.get(i).add(0, cur);
        }
        result.addAll(lists);
    }
    return result;
}
{% endhighlight %}
