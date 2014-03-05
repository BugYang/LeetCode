public class Solution {
    public int minPathSum_DP_Omn(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = grid[i][j];
                } else if (i == 0) {
                    result[i][j] = result[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    result[i][j] = result[i-1][j] + grid[i][j];
                } else {
                    result[i][j] = Math.min(result[i-1][j], result[i][j-1]) + grid[i][j];
                }
            }
        }
        return result[m-1][n-1];
    }
}
