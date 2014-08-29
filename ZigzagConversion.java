public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
            
        char[] str = s.toCharArray();
        char[] result = new char[str.length];
        int idx = 0, step;
        
        for (int i = 0; i < nRows; i++) {
            step = 2 * (nRows - 1 - i);
            int j = i;
            while (j < str.length) {
                if (step != 0)
                    result[idx++] = str[j];
                j += step;
                step = 2 * (nRows - 1) - step;
            }
        }
        
        return new String(result);
    }
}