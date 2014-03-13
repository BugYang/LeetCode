public class Solution {
    public boolean canJump(int[] A) {
        Map<Integer, Boolean> buf = new HashMap<Integer, Boolean>();
        return canJumpHelper(A, 0, buf);
    }

    public boolean canJumpHelper(int[] A, int cur, Map<Integer, Boolean> buf) {
        if (cur >= A.length-1) {
            return true;
        }
        for (int i = A[cur]; i > 0; i--) {
            if (!buf.containsKey(i)) {
                buf.put(i, canJumpHelper(A, cur+i, buf));
            }
            return buf.get(i);
        }
        return false;
    }
}
