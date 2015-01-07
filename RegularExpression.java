public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, 0, p, 0);
    }
    
    private boolean isMatchHelper(String s, int sIdx, String p, int pIdx) {
        if (pIdx == p.length()) {
            return sIdx == s.length();
        }
        
        if (pIdx+1 < p.length() && p.charAt(pIdx+1) == '*') {
            if (isMatchHelper(s, sIdx, p, pIdx+2)) {
                return true;
            }
            if (p.charAt(pIdx) == '.') {
                for (int i = sIdx; i < s.length(); i++) {
                    if (isMatchHelper(s, i+1, p, pIdx+2)) {
                        return true;
                    }
                }
                return false;
            } else {
                for (int i = sIdx; i < s.length() && s.charAt(i) == p.charAt(pIdx); i++) {
                    if (isMatchHelper(s, i+1, p, pIdx+2)) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            if (sIdx == s.length()) {
                return false;
            } else if (p.charAt(pIdx) == '.' || s.charAt(sIdx) == p.charAt(pIdx)) {
                return isMatchHelper(s, sIdx+1, p, pIdx+1);
            } else {
                return false;
            }
        }
    }
}