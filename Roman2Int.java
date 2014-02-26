public class Solution {
    private String digit = "IVXLCDM";
    private int[] dec = {1, 5, 10, 50, 100, 500, 1000};

    public int romanToInt(String s) {
        int result = 0, len = s.length();

        for (int i = 0; i < len; i++) {
            int cur = dec[digit.indexOf(s.charAt(i))];
            int next = i+1 < len ? dec[digit.indexOf(s.charAt(i+1))] : cur;
            if (cur < next) {
                result += next-cur;
                i++;
            } else {
                result += cur;
            }
        }

        return result;
    }
}
