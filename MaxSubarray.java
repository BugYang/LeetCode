public class Solution {
    public int maxSubArray_On(int[] A) {
        int T = A[0], minT = Math.min(0, A[0]), max = A[0];
        for (int i = 1; i < A.length; i++) {
            T += A[i];
            max = T-minT > max ? T-minT : max;
            minT = T < minT ? T : minT;
        }
        return max;
    }

    public int maxSubArray_yet_another_On(int[] A) {
        int sum = A[0], max = A[0];
        for (int i = 1;i < A.length; i++) {
            sum = A[i] + (sum < 0 ? 0 : sum);
            max = sum > max ? sum : max;
        }
        return max;
    }

    public int maxSubArray_recur(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        int div = A.length/2;
        int lMax = maxSubArray_recur(Arrays.copyOfRange(A, 0, div));
        int rMax = div+1 < A.length ? maxSubArray_recur(Arrays.copyOfRange(A, div+1, A.length)) : lMax;
        int mMax = A[div];
        int sum = 0;
        for (int i = div; i >= 0; i--) {
            sum += A[i];
            mMax = Math.max(sum, mMax);
        }
        sum = mMax;
        for (int i = div + 1; i < A.length; i++) {
            sum += A[i];
            mMax = Math.max(sum, mMax);
        }

        return Math.max(Math.max(lMax, rMax), mMax);
    }

}
