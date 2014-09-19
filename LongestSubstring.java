public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
            
        Set<Character> set = new HashSet<Character>();
        Queue<Character> queue = new LinkedList<Character>();
        int max = 0, len = s.length();
        char ch, tmp;
        
        for (int i = 0; i < len; i++) {
            ch = s.charAt(i);
            if (set.contains(ch)) {
                do {
                    tmp = queue.poll();
                    set.remove(tmp);
                } while (tmp != ch);
            }
            queue.add(ch);
            set.add(ch);
            max = Math.max(max, set.size());
        }
        
        return max;
    }
}