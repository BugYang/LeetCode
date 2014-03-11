public class Solution {
    public boolean search(int[] A, int target) {
        return searchHelper(A, 0, A.length-1, target) != -1;
    }

    public int searchHelper(int[] A, int begin, int end, int target) {
        while (begin < end) {
            int mid = (begin + end)/2;
            if (A[mid] == target) {
                return mid;
            } else if (A[begin] < A[mid]) {
                if (A[begin] <= target && target < A[mid]) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            } else if (A[begin] == A[mid]) {
                begin += 1;
            } else {
                if (A[mid] < target && target <= A[end]) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return A[begin] == target ? begin : -1;
    }
}
