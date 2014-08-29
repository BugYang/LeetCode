public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length <= 1)
            return 0;
            
        int[] reach = new int[A.length];
        reach[0] = 0;
        for (int i = 1; i < A.length; i++)
            reach[i] = -1;

        for (int i = 0; i < A.length - 1; i++) {
            int j = A[i] > A.length-1-i ? A.length-1-i : A[i];
            for (;j > 0; j--) {
                if (reach[i+j] == -1) {
                    reach[i+j] = reach[i] + 1;
                    if (i+j == A.length - 1)
                        return reach[i+j];
                }
            }
        }
        return -1;
    }
}