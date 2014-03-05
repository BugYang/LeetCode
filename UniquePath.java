public class Solution {
    public int uniquePaths_math(int m, int n) {
        long result = 1, x = 2;
        for (int i = m; i <= m+n-2; i++) {
            long a = result, b = i;
            result = a * b;
            while (result%x == 0 && x < n) {
                result /= x++;
            }
        }
        return (int)result;
    }

    public int uniquePaths_recur(int m, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(genKey(1,1), 1);
        return uniquePathsHelper(m, n, map);
    }

    public int genKey(int m, int n) {
        return m * 1000 + n;
    }

    public int uniquePathsHelper(int m, int n, HashMap<Integer, Integer> map) {
        int key = genKey(m, n);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int result = 0;
        result += m > 1 ? uniquePathsHelper(m-1, n, map) : 0;
        result += n > 1 ? uniquePathsHelper(m, n-1, map) : 0;
        map.put(key, result);
        return result;
    }

    public int uniquePaths_DP(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i * j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }
        return result[m-1][n-1];
    }
}
