public class Solution {
	// time O(m+n), space O(1)
    private int findKth(int[] A, int[] B, int k) {
        int count = 0, i = 0, j = 0;
        
        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                if (++count == k)
                    return A[i];
                i++;
            } else {
                if (++count == k)
                    return B[j];
                j++;
            }
        }
        
        while (i < A.length) {
            if (++count == k)
                return A[i];
            i++;
        }
        
        while (j < B.length) {
            if (++count == k)
                return B[j];
            j++;
        }
        
        // should not reach here
        return 0;
    }
    
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 == 1)
            return findKth(A, B, len/2+1);
        else
            return (findKth(A, B, len/2) + findKth(A, B, len/2+1))/2.0;
    }
}
