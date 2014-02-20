import java.util.HashMap;
import java.util.TreeSet;

public class SingleNumber {
    public static int singleNumber_XOR(int[] A) {
        int result = 0;
        for (int i : A) {
            result ^= i;
        }
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

    public static int singleNumber_Set(int[] A) {
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int i : A) {
            if (s.contains(i)) {
                s.remove(i);
            } else {
                s.add(i);
            }
        }
        return s.first();
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 3};
        System.out.println("" + SingleNumber.singleNumber_XOR(A));
        System.out.println("" + SingleNumber.singleNumber_HashMap(A));
        System.out.println("" + SingleNumber.singleNumber_Set(A));
    }
}
