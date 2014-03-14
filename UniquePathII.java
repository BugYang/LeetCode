public class Solution {
    public int uniquePathsWithObstacles_DP(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] cnt = new int[n];
        cnt[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    cnt[j] = 0;
                } else if (j-1 >= 0) {
                    cnt[j] += cnt[j-1];
                }
            }
        }
        return cnt[n-1];
    }
}
