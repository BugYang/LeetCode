public class Solution {
    public boolean isScramble(String s1, String s2) {
            if (s1.equals(s2))
                return true;
                
            int len = s1.length();
            char[] str1 = s1.toCharArray(), str2 = s2.toCharArray();
            
        for (int i = 1; i < len; i++) {
            boolean foundL = false, foundR = false;
            for (int j = 0; j < i; j++) {
                if (str2[j] == str1[0]) {
                    foundL = true;
                    break;
                }   
            }   
            for (int j = len-i; j < len; j++) {
                if (str2[j] == str1[0]) {
                    foundR = true;
                    break;
                }   
            }
            char[] s1l = Arrays.copyOfRange(str1, 0, i);
            Arrays.sort(s1l);
            char[] s1r = Arrays.copyOfRange(str1, i, len);
            Arrays.sort(s1r);
            
            if (foundL) {
                // abab
                char[] s2l1 = Arrays.copyOfRange(str2, 0, i);
                Arrays.sort(s2l1);
                char[] s2r1 = Arrays.copyOfRange(str2, i, len);
                Arrays.sort(s2r1);
                if (Arrays.equals(s1l, s2l1) && Arrays.equals(s1r, s2r1))
                    if (isScramble(s1.substring(0, i), s2.substring(0, i)))
                        if (isScramble(s1.substring(i), s2.substring(i)))
                            return true;
            }
            
            if (foundR) {
                // abba
                char[] s2l2 = Arrays.copyOfRange(str2, 0, len-i);
                Arrays.sort(s2l2);
                char[] s2r2 = Arrays.copyOfRange(str2, len-i, len);
                Arrays.sort(s2r2);
                if (Arrays.equals(s1l, s2r2) && Arrays.equals(s1r, s2l2))
                    if (isScramble(s1.substring(0, i), s2.substring(len-i)))
                        if (isScramble(s1.substring(i), s2.substring(0, len-i)))
                            return true;                
            }
        }
        
        return false;
    }
}