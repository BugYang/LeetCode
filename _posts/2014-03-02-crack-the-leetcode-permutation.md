---
layout: post
title: Crack the LeetCode - Permutations
---

{{ page.title }}
================

<p class="meta">02 March 2014 - Shanghai </p>

**Problem**:  
Given a collection of numbers, return all possible permutations.

**Example**:    
INPUT: [1,2,3]  
OUTPUT: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]

**Solution 0**:  
Actually, the leetcode OJ assume the numbers in the collection have no duplicates, so you can just use normal recursive method to solve it.

*Time Complexity*:O(2^n)  
*Space Complexity*:O(2^n)  

{% highlight java %}  
public ArrayList<ArrayList<Integer>> permute(int[] num) {
    return permuteHelper(num, 0, num.length-1);
}

public ArrayList<ArrayList<Integer>> permuteHelper(int[] num, int begin, int end) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (begin > end) {
        return result;
    }
    if (begin == end) {
        ArrayList<Integer> p = new ArrayList<Integer>();
        p.add(num[begin]);
        result.add(p);
        return result;
    }

    ArrayList <ArrayList<Integer>> subResult = permuteHelper(num, begin + 1, end);
    for (ArrayList<Integer> list : subResult) {
        for (int i = 0; i <= end - begin; i++) {
            ArrayList<Integer> p = new ArrayList<Integer>();
            p.addAll(list.subList(0, i));
            p.add(num[begin]);
            p.addAll(list.subList(i, end -begin));
            result.add(p);
        }
    }
    return result;
}
{% endhighlight %}
