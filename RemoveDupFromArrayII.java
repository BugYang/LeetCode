public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length < 3) {
            return A.length;
        }

        int len = 2, lastlast = A[0], last = A[1];
        for (int i = 2; i < A.length; i++) {
            if (A[i] != lastlast) {
                lastlast = last;
                last = A[i];
                A[len++] = A[i];
            }
        }
        return len;
    }
}
