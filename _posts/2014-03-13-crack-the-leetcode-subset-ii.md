---
layout: post
title: Crack the LeetCode - Subsets II
---

{{ page.title }}
================

<p class="meta">13 March 2014 - Shanghai </p>

**Problem**:   
Given a collection of integers that might contain duplicates, S, return all possible subsets. Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.

**Example**:   
INPUT: [1,2,2]  
OUTPUT: [[2],[1],[1,2,2],[2,2],[1,2],[]]

**Solution 0**:  
Compared with the original problem, the only difference is there are duplicates, which makes the original solution generate duplicate subsets. The key observation is when duplicates will be generated. For the example input, if you have already handle 1,2, you will get two sets of subsets: one is got by handling 1, the other is got by handling 2. When you handle another 2, you will get duplicate subsets if you append 2 to the first sets of subsets. So the solution is you need record how many new subsets is got by handling last element, and when you meet a duplicate, you only append it to the last sets of subsets.

*Time Complexity*:O(2^n)  
*Space Complexity*:O(2^n)  

{% highlight java %}  
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        int[] sorted_num = Arrays.copyOf(num, num.length);
        Arrays.sort(sorted_num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        int new_cnt = 1;
        for (int i = 0; i < sorted_num.length; i++) {
            int len = result.size();
            int begin = i > 0 && sorted_num[i] == sorted_num[i-1] ? len-new_cnt : 0;
            new_cnt = 0;
            for (int j = begin; j < len; j++) {
                ArrayList<Integer> set = (ArrayList<Integer>)result.get(j).clone();
                set.add(sorted_num[i]);
                result.add(set);
                new_cnt++;
            }
        }
        return result;
    }
}
{% endhighlight %}
