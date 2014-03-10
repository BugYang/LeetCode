public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }
        int x = 0, y = 0, i = 1;
        result[x][y] = i++;
        while (i <= n*n) {
            while (y+1 < n && result[x][y+1] == 0) {
                result[x][++y] = i++;
            }
            while (x+1 < n && result[x+1][y] == 0) {
                result[++x][y] = i++;
            }
            while (y-1 >= 0 && result[x][y-1] == 0) {
                result[x][--y] = i++;
            }
            while (x-1 >= 0 && result[x-1][y] == 0) {
                result[--x][y] = i++;
            }
        }
        return result;
    }
}
