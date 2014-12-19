public class Solution {
    public int maxProduct(int[] A) {
        int[] max = new int[A.length];
        int[] min = new int[A.length];
        int result;
        
        max[0] = A[0];
        min[0] = A[0];
        result = max[0];
        for (int i = 1; i < A.length; i++) {
            max[i] = (A[i] > 0 ? max[i-1] : min[i-1]) * A[i];
            max[i] = Math.max(max[i], A[i]);
            min[i] = (A[i] > 0 ? min[i-1] : max[i-1]) * A[i];
            min[i] = Math.min(min[i], A[i]);
            result = Math.max(result, max[i]);
        }
        
        return result;
    }
}