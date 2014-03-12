public class Solution {
    public int trap(int[] A) {
        int total = 0, lmax = 0, rmax = 0;
        for (int i = 0; i < A.length; i++) {
            if (i >= rmax) {
                rmax = i;
                for (int r = i+1; r < A.length; r++) {
                    rmax = A[r] > A[rmax] ? r : rmax;
                }
            }
            lmax = tA[i] > A[lmax] ? i : lmax;
            total += Math.min(A[lmax], A[rmax]) - A[i];
        }
        return total;
    }
}
