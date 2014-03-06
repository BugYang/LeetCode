---
layout: post
title: Crack the LeetCode - Search a 2D Matrix
---

{{ page.title }}
================

<p class="meta">06 March 2014 - Shanghai </p>

**Problem**:  
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties: Integers in each row are sorted from left to right. The first integer of each row is greater than the last integer of the previous row.

**Example**:    
INPUT: [[1,3,5,7],[10, 11, 16, 20],[23, 30, 34, 50]],3  
OUTPUT: true

**Solution 0**:  
By making good use of the properties of the given matrix, you can firstly search which row the target can be and then search which column the target is in this row. 

*Time Complexity*:O(m+n)  
*Space Complexity*:O(1)  

{% highlight java %}  
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int row = m-1, column = 0;

    while (row >= 0 && matrix[row][column] > target)  {
        row--;
    }
    if (row < 0) {
        return false;
    }

    while (column < n && matrix[row][column] != target) {
        column++;
    }
    return column < n && matrix[row][column] == target;
}
{% endhighlight %}

**Solution 1**:  
You can optimize the algorithm below by using binary searching.

*Time Complexity*:O(log(mn))  
*Space Complexity*:O(1)  

{% highlight java %}  
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int begin = 0, end = m-1;
    while (begin < end) {
        int mid = (begin+end)/2;
        if (matrix[mid][0] > target) {
            end = mid - 1;
        } else if (matrix[mid][0] <= target && matrix[mid][n-1] >= target) {
            begin = mid;
            break;
        } else {
            begin = mid + 1;
        }
    }

    return Arrays.binarySearch(matrix[begin], target) >= 0;
} 
{% endhighlight %}
