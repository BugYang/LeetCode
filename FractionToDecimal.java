public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long top = Math.abs((long)numerator), bottom = Math.abs((long)denominator);
        
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0)
            sb.append('-');
        
        // integer part
        sb.append(top / bottom);
        
        // fraction part
        long remain = top % bottom;
        if (remain != 0) {
            sb.append('.');
            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            while (remain != 0) {
                remain *= 10;
                if (map.containsKey(remain)) {
                    sb.insert(map.get(remain), "(");
                    sb.append(")");
                    break;
                }
                map.put(remain, sb.length());
                sb.append(remain / bottom);
                remain %= bottom;
            }
        }
        
        return sb.toString();
    }
}