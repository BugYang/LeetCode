public class Solution {
    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        int len = s.length(); 
        int maxL = 0, maxR = 0;
        for (int i = 0; i < 2*len-1; i++) {
            int radius = 0, curR = 0, curL = 0;
            if (i%2 == 0) {
                while (i/2-radius-1 >= 0 && i/2+radius+1 < len && s.charAt(i/2-radius-1) == s.charAt(i/2+radius+1))
                    radius++;
                curL = i/2-radius;
                curR = i/2+radius;
            } else {
                while (i/2-radius+1 >= 0 && i/2+radius < len && s.charAt(i/2-radius+1) == s.charAt(i/2+radius))
                    radius++;
                curL = i/2-radius+2;
                curR = i/2+radius-1;
            }

            if (curR - curL > maxR - maxL) {
                maxR = curR;
                maxL = curL;
            }
        }
        
        return s.substring(maxL, maxR+1);
    }
}