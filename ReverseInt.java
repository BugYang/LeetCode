public class Solution {
    public int reverse(int x) {
        String abs_str = Integer.toString(Math.abs(x));
        int rabsx = Integer.parseInt(new StringBuilder(abs_str).reverse().toString());
        return rabsx * (x < 0 ? -1 : 1);
    }
}
