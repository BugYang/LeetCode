public class Solution {

    public int numTrees_iter(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            result[i] = 0;
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i-1-j];
            }
        }
        return result[n];
    }

        
    public int numTrees_recur(int n) {
        int result = 0;
        if (n <= 1) {
            result = 1;
        } else {
            for (int i = 0; i < n; i++) {
                result += numTrees_recur(i) * numTrees_recur(n-1-i);
            }
        }
        return result;
    }

    public int numTrees_catalan(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * (4*i-2) / (i+1);
        }
        return result;
    }
}
