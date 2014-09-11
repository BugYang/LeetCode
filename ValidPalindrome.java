public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null)
            return true;
            
        int len = s.length(), cnt = 0;
        char[] str = new char[len];
        for (int i = 0; i < len; i++)
            if (Character.isLetterOrDigit(s.charAt(i)))
                str[cnt++] = Character.toLowerCase(s.charAt(i));
        return isPalindromeHelper(str, cnt);
    }
    
    public boolean isPalindromeHelper(char[] str, int len) {
        for (int i = 0; i < len/2; i++)
            if (str[i] != str[len-1-i])
                return false;
        
        return true;
    }
}