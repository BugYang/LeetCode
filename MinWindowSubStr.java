public class Solution {
    public String minWindow(String S, String T) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char ch;
        for (int i = 0; i < T.length(); i++) {
            ch = T.charAt(i);
            map.put(ch, map.containsKey(ch) ? map.get(ch)+1 : 1);
        }
        
        int minLowIdx = -1, minHighIdx = -1;
        int lowIdx = 0, highIdx = 0;
        while (lowIdx < S.length() && !map.containsKey(S.charAt(lowIdx)))
            lowIdx++;
        highIdx = lowIdx;
        
        while (lowIdx < S.length() && highIdx < S.length()) {
            ch = S.charAt(highIdx);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                while (isFinished(map)) {
                    if (minLowIdx == -1 || highIdx-lowIdx < minHighIdx-minLowIdx) {
                        minLowIdx = lowIdx;
                        minHighIdx = highIdx;
                    }
                    ch = S.charAt(lowIdx);
                    map.put(ch, map.get(ch)+1);
                    do {
                        lowIdx++;
                    } while (lowIdx < S.length() && !map.containsKey(S.charAt(lowIdx)));
                }
            }
            highIdx++;
        }
        
        return minLowIdx == -1 ? "" : S.substring(minLowIdx, minHighIdx+1);
    }
    
    private boolean isFinished(Map<Character, Integer> map) {
        for (int v : map.values()) {
            if (v > 0) {
                return false;
            }
        }
        return true;
    }
}