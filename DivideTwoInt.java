public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
            
        StringBuilder sb = new StringBuilder();
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
        
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            sb.append('-');
        
        long magnitude = 1;
        while (magnitude * 10 <= a)
            magnitude *= 10;
        
        long remain = 0, digit;
        while (magnitude >= 1) {
            remain = 10 * remain + a / magnitude % 10;
            digit = remain / b;
            remain %= b;
            sb.append(digit);
            magnitude /= 10;
        }
        
        return Integer.parseInt(sb.toString());
    }
}