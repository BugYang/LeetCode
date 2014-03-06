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
    }    public boolean searchMatrix(int[][] matrix, int target) {
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
}
