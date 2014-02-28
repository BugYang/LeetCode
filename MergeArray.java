public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m+n-1;
        while (m > 0 && n > 0) {
            A[i--] = A[m-1] > B[n-1] ? A[m-- -1] : B[n-- -1];
        }
        while (m > 0) {
            A[i--] = A[m-- -1];
        }
        while (n > 0) {
            A[i--] = B[n-- -1];
        }
    }
}
