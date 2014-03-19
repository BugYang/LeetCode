public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String base = countAndSay(n-1), result="";
        int count = 1, len = base.length(), i;
        for (i = 1; i < len; i++) {
            if (base.charAt(i) == base.charAt(i-1)) {
                count++;
            } else {
                result += count;
                result += base.charAt(i-1);
                count = 1;
            }
        }
        if (count != 0) {
            result += count;
            result += base.charAt(i-1);
        }

        return result;
    }
}
