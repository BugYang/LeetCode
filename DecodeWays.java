public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        HashMap<Integer, Integer> num = new HashMap<Integer, Integer>();
        numDecodingsHelper(s.toCharArray(), 0, num);
        return num.get(0);
    }
    
    public int numDecodingsHelper(char[] str, int begin, HashMap<Integer, Integer> num) {
        if (begin >= str.length)
            return 1;
        if (num.containsKey(begin))
            return num.get(begin);
        
        int result = 0;
        // one
        if (str[begin] != '0') {
            result += numDecodingsHelper(str, begin+1, num);
            // two
            if (begin+2 <= str.length && Integer.parseInt(new String(str, begin, 2)) < 27)
                result += numDecodingsHelper(str, begin+2, num);
        }
        num.put(begin, result);
        return result;
    }
}