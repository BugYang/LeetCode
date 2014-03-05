public class Solution {
    public int uniquePaths(int m, int n) {
        long result = 1, x = 2;
        for (int i = m; i <= m+n-2; i++) {
            long a = result, b = i;
            while (a%x == 0 && x < n) {
                a /= x++;
            }
            while (b%x == 0 && x < n) {
                b /= x++;
            }
            result = a * b;
            while (result%x == 0 && x < n) {
                result /= x++;
            }
        }
        return (int)result;
    }
}