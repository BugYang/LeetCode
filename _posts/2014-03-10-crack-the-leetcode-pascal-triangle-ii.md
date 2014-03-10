---
layout: post
title: Crack the LeetCode - Pascal's Triangle II
---

{{ page.title }}
================

<p class="meta">10 March 2014 - Shanghai </p>

**Problem**:   
Given an index k, return the kth row of the Pascal's triangle.

**Example**:   
INPUT: 3   
OUTPUT: [1,3,3,1]

**Solution 0**:  
You can use the method in its original problem. But if you want to reduce the space usage to O(k), you need pay more effort. Intuitively, you can use two rows and use them alternatively to generate the new row. But it wastes too much time on copying rows from one to another. A more elegant method is just to save one row. But the problem is you may overwrite the element you will need. So how to break the dependencies is the key point. Actually, if you notice the newer row[j] only depends on its last version and row[j-1], you can really make use of it by generating new row from the end to the begining so that you won' t overwrite the elements which are useful later.

*Time Complexity*:O(n^2)  
*Space Complexity*:O(n)  

{% highlight java %}  
public ArrayList<Integer> getRow(int rowIndex) {
    int[] row = new int[rowIndex+1];
    for (int i = 0; i <= rowIndex; i++) {
        for (int j = i; j >= 0; j--) {
            row[j] = (j == 0 || j == i) ? 1 : row[j-1] + row[j];
        }
    }

    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < row.length; i++) {
        result.add(row[i]);
    }
    return result;
}
{% endhighlight %}

**NOTE:**  
After figuring out those algorithm problems, I find the keypoint to figure out the solution is: first, you need to observe the key properties in problems' nature; second, you need to really make use of them. 
