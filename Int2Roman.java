public class Solution {
    private String[] digit = {"I", "IV", "V", "IX","X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private int[] dec = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public String intToRoman(int num) {
        String result = "";
        for (int i = digit.length-1; i >= 0 && num > 0; i--) {
            if (num < dec[i]) {
                continue;
            } else {
                for (int j = 0; j < num/dec[i]; j++) {
                    result += digit[i];
                }
                num = num % dec[i];
            }
        }
        return result;
    }
}
