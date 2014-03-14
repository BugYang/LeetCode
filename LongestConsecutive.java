public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }

        int len, max = 0;
        for (int i : num) {
            len = 0;
            int left = i, right = i+1;
            while (set.contains(left)) {
                set.remove(left--);
                len++;
            }
            while (set.contains(right)) {
                set.remove(right++);
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
