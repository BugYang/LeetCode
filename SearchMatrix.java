public class Solution {
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
}
