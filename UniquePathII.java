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

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Map<Integer, Integer> buf = new HashMap<Integer, Integer>();
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        return uniquePathHelper(obstacleGrid, m-1, n-1, buf);
    }

    public int getKey(int x, int y) {
        return x*1000 + y;
    }

    public int uniquePathHelper(int[][] grid, int x, int y, Map<Integer, Integer> buf) {
        int key = getKey(x, y);
        if (!buf.containsKey(key)) {
            int result = 0;
            if (grid[x][y] == 1) {
                result = 0;
            } else if (x == 0 && y == 0) {
                result = 1;
            } else {
                result += x == 0 ? 0 : uniquePathHelper(grid, x-1, y, buf);
                result += y == 0 ? 0 : uniquePathHelper(grid, x, y-1, buf);
            }
            buf.put(key, result);
        }
        return buf.get(key);
    }
}
