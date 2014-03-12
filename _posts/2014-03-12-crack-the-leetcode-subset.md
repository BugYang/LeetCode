---
layout: post
title: Crack the LeetCode - Subsets
---

{{ page.title }}
================

<p class="meta">12 March 2014 - Shanghai </p>

**Problem**:   
Given a set of distinct integers, S, return all possible subsets. Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.

**Example**:   
INPUT: [1,2,3]   
OUTPUT: [[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]] 

**Solution 0**:  
It seems a easy recursive problem, but you have to be careful that your subsets must be in non-descending order, and the given S is not guaranteed as non-descending order, so you have to sort it before recursion.

*Time Complexity*:O(2^n)  
*Space Complexity*:O(2^n)  

{% highlight java %}  
public ArrayList<ArrayList<Integer>> subsets_recur(int[] S) {
    int[] SS = Arrays.copyOf(S, S.length);
    Arrays.sort(SS);
    return subsetsHelper(SS, SS.length-1);
}

public ArrayList<ArrayList<Integer>> subsetsHelper(int[] S, int cur) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (cur == -1) {
        result.add(new ArrayList<Integer>());
    } else {
        result.addAll(subsetsHelper(S, cur-1));
        int len = result.size();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> set = (ArrayList<Integer>)result.get(i).clone();
            set.add(S[cur]);
            result.add(set);
        }
    }
    return result;
}
{% endhighlight %}

**Solution 1**:  
It also easy to transform this recursion to iteration.

*Time Complexity*:O(2^n)  
*Space Complexity*:O(2^n)  

{% highlight java %}  
public ArrayList<ArrayList<Integer>> subsets_iter(int[] S) {
    int[] SS = Arrays.copyOf(S, S.length);
    Arrays.sort(SS);

    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    result.add(new ArrayList<Integer>());
    for (int num : SS) {
        int len = result.size();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> set = (ArrayList<Integer>)result.get(i).clone();
            set.add(num);
            result.add(set);
        }
    }

    return result;
}
{% endhighlight %}
