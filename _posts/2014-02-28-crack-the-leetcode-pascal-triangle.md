---
layout: post
title: Crack the LeetCode - Pascal's Triangle
---

{{ page.title }}
================

<p class="meta">28 February 2014 - Shanghai </p>

**Problem**:  
Given numRows, generate the first numRows of Pascal's triangle.

**Example**:    
INPUT: 3  
OUTPUT: [[1],[1,1],[1,2,1]]

**Solution 0**:  
Once you understand the rules of pascal's triangle, the solution is obvious.

*Time Complexity*:O(n^2)  
*Space Complexity*:O(n^2)  

{% highlight java %}  
public ArrayList<ArrayList<Integer>> generate(int numRows) {
    ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < numRows; i++) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int j = 0; j <= i; j++) {
            if (j == 0 || j == i) {
                row.add(1);
            } else {
                row.add((Integer)triangle.get(i-1).get(j-1) + (Integer)triangle.get(i-1).get(j));
            }
        }
        triangle.add(row);
    }
    return triangle;
}
{% endhighlight %}
