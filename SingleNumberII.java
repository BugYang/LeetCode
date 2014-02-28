public class Solution {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        for (i = 0; i < A.length; i++) {
            map.put(A[i], map.containsKey(A[i]) ? map.get(A[i])+1 : 1);
        }

        for (i = 0; i < A.length; i++) {
            if (map.get(A[i]) != 3) {
                break;
            }

        }
        return A[i];
    }
}
