public class Solution {
    public void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][matrix.length-1-i] = result[i][j];
            }
        }
    }
}

public class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < (matrix.length+1)/2; i++) {
            for (int j = 0; j < (matrix.length+1)/2; j++) {
                int x = i, y = j, cur = matrix[x][y];
                for (int k = 0; k < 4; k++) {
                    int t = matrix[y][matrix.length-1-x];
                    matrix[y][matrix.length-1-x] = cur;
                    cur = t;
                    int x1 = y, y1 = matrix.length-1-x;
                    x = x1; y = y1;
                }
            }
        }
    }
}
