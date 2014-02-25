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
}
