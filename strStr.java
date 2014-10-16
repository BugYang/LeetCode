public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle == null || haystack == null)
            return null;
            
        int len0 = haystack.length();
        int len1 = needle.length();
            
        for (int i = 0; i < len0-len1+1; i++) {
            boolean match = true;
            for (int j = 0; j < len1; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match == true) {
                return haystack.substring(i);
            }
        }
        
        return null;
    }
}