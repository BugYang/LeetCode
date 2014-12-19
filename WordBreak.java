public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] reachable = new boolean[s.length() + 1];
        reachable[0] = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (!reachable[i])
                continue;
            for (int j = i+1; j <= s.length(); j++)
                if (dict.contains(s.substring(i, j)))
                    reachable[j] = true;
        }
        
        return reachable[reachable.length - 1];
    }
}