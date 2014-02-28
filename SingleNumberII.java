public class Solution {
    public int singleNumber_On(int[] A) {
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

    public int singleNumber_O1(int[] A) {
        int result = 0;
        int[] bits = new int[32];
        for (int i : A) {
            for (int j = 0; j < 32; j++) {
                bits[j] += (result>>j & 1) + (i>>j & 1);
            }
            result += bits[i]%3 << i;
        }

        return result;
    }
}
