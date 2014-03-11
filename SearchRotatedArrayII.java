public class Solution {
    public int search_bf(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int search_bs(int[] A, int target) {
        return searchHelper(A, 0, A.length-1, target);
    }

    public int searchHelper(int[] A, int begin, int end, int target) {
        while (begin < end) {
            int mid = (begin + end)/2;
            if (A[mid] == target) {
                return mid;
            } else if (A[begin] <= A[mid]) {
                if (A[begin] <= target && target < A[mid]) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
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
