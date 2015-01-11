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

	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;

		Set<Character> set = new HashSet<Character>();
		int i = 0;
		int j = 0;
		int max = 0;

		while (j < s.length()) {
			while (set.contains(s.charAt(j))) {
				set.remove(s.charAt(i));
				i++;
			}
			set.add(s.charAt(j));
			j++;
			max = Math.max(max, set.size());
		}

		return max;
	}
}
