---
layout: post
title: Crack the LeetCode - Valid Sudoku
---

{{ page.title }}
================

<p class="meta">13 March 2014 - Shanghai </p>

**Problem**:   
Determine if a Sudoku is valid. The Sudoku board could be partially filled, where empty cells are filled with the character '.'. A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

**Example**:   
INPUT: 
OUTPUT: 

**Solution 0**:  
The rule of sudoku is straightforward to use to check the board. The only difficulty is how to write simple code. The keypoint is, you have to check row, column and square, which are all rectangles. So you can abstract the check function as a check of rectangle.

*Time Complexity*:O(n^2)  
*Space Complexity*:O(1)  

{% highlight java %}  
public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
        if (!isValidGroup(board, i, 0, i, 8) || !isValidGroup(board, 0, i, 8, i)) {
            return false;
        }
    }

    for (int i = 0; i < 9; i += 3) {
        for (int j = 0; j < 9; j += 3) {
            if (!isValidGroup(board, i, j, i+2, j+2)) {
                return false;
            }
        }
    }
    return true;
}

public boolean isValidGroup(char[][] board, int x0, int y0, int x1, int y1) {
    Set<Character> set = new HashSet<Character>();
    for (int i = x0; i <= x1; i++) {
        for (int j = y0; j <= y1; j++) {
            if (board[i][j] != '.' && set.contains(board[i][j])) {
                return false;
            }
            set.add(board[i][j]);
        }
    }
    return true;
}
{% endhighlight %}
