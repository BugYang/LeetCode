import java.util.HashMap;

public class SingleNumber {
    public static int singleNumber_XOR(int[] A) {
        int result = A[0];
        for (int i = 1; i < A.length; i++)
            result ^= A[i];
        return result;
    }

    public static int singleNumber_HashMap(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;

        for (i = 0; i < A.length; i++) {
            map.put(A[i], map.containsKey(A[i]) ? 2 : 1);
        }

        for (i = 0; i < A.length; i++) {
            if (map.get(A[i]) == 1) {
                break; 
            }
        }

        return A[i];
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 3};
        System.out.println("" + SingleNumber.singleNumber_HashMap(A));
    }
}
