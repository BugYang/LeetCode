public class Solution {
    public void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        double origin = (matrix.length - 1.0) / 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int x = (int)(j + 0.5);
                int y = (int)(2 * origin - i + 0.5);
                matrix[x][y] = result[i][j];
            }
        }
    }
}
