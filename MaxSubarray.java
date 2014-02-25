public class Solution {
    public int maxSubArray_On(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        int T = 0, minT = 0, max = A[0];
        for (int i = 0; i < A.length; i++) {
            T += A[i];
            max = T-minT > max ? T-minT : max;
            minT = T < minT ? T : minT;
        }
        return max;
    }
}
