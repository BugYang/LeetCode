public class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length+1];
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            carry += digits[i];
            result[i+1] = carry % 10;
            carry /= 10;
        }

        if (carry != 0) {
            result[0] = carry;
            return result;
        } else {
            return Arrays.copyOfRange(result, 1, result.length);
        }
    }
}
