public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int len = 1, num = x;
        while ((num /= 10) != 0) {
            len++;
        }

        for (int i = 0; i < len/2; i++) {
            num = x;
            for (int j = 0; j < i; j++) {
                num /= 10;
            }
            int a = num % 10;

            num = x;
            for (int j = 0; j < len-1 - i; j++) {
                num /= 10;
            }
            int b = num % 10;

            if (a != b) {
                return false;
            }
        }
        return true;
    }
}
