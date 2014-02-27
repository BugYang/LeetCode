public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int len = 1, last = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] != last) {
                A[len++] = A[i];
                last = A[i];
            }
        }

        return len;
    }
}
