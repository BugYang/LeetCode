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
            if (getDigitAt(x, i) != getDigitAt(x, len-1-i)) {
                return false;
            }
        }
        return true;
    }

    public int getDigitAt(int num, int idx) {
        while (idx-- > 0) {
            num /= 10;
        }
        return num % 10;
    }
}
