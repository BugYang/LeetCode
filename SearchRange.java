public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = binarySearchFirst(A, target);
        result[1] = binarySearchLast(A, target);
        return result;
    }

    public int binarySearchFirst(int[] A, int target) {
        int l = 0, h = A.length-1, m;
        while (l <= h && l >= 0 && h >= 0) {
            m = (h+l)/2;
            if (A[m] == target) {
                if (m == 0 || A[m-1] != A[m]) {
                    return m;
                } else {
                    h = m-1;
                }
            } else if (A[m] < target) {
                l = m+1;
            } else {
                h = m-1;
            }
        }           
        return -1;
    }

    public int binarySearchLast(int[] A, int target) {
        int l = 0, h = A.length-1, m;
        while (l <= h && l >= 0 && h >= 0) {
            m = (h+l)/2;
            if (A[m] == target) {
                if (m == A.length-1 || A[m+1] != A[m]) {
                    return m;
                } else {
                    l = m+1;
                }
            } else if (A[m] < target) {
                l = m+1;
            } else {
                h = m-1;
            }
        }           
        return -1;
    }
}
