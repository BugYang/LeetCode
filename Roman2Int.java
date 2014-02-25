public class Solution {
    private String digit = "IVXLCDM";
    private int[] dec = {1, 5, 10, 50, 100, 500, 1000};

    public int romanToInt(String s) {
        int result = 0, len = s.length();
        int last = dec[digit.indexOf(s.charAt(0))], cur;
        int accumu = last;

        for (int i = 1; i < len; i++) {
            cur = dec[digit.indexOf(s.charAt(i))];
            if (last == cur) {
                accumu += cur;
            } else {
                result += last < cur ? cur-accumu : accumu;
                accumu = last < cur ? 0 : cur;
            }
            last = cur;
        }
        result += accumu;

        return result;
    }
}
