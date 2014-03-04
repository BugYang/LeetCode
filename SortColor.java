public class Solution {
    public void sortColors_2pass(int[] A) {
        int[] cnt = new int[3];
        for (int i : A) {
            cnt[i]++;
        }
        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < cnt[j]; k++) {
                A[i++] = j;
            }
        }
    }
    public void sortColors_1pass(int[] A) {
        int p0 = -1, p1 = -1, p2 = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 2) {
                A[++p2] = 2;
            } else if (A[i] == 1) {
                A[++p2] = 2;
                A[++p1] = 1;
            } else {
                A[++p2] = 2;
                A[++p1] = 1;
                A[++p0] = 0;
            }
        }
    }
}
