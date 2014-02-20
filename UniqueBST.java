public class Solution {

    public int numTrees_iter(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                result[i] = 1;
            } else {
                result[i] = 0;
                for (int j = 0; j < i; j++) {
                    result[i] += result[j] * result[i-1-j];
                }
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
                result += numTrees(i) * numTrees(n-1-i);
            }
        }
        return result;
    }
}
