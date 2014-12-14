public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s != null && s.length() >= 4 && s.length() <= 12) {
            char[] str = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            restoreIpAddressesHelper(str, 0, sb, 4, result);
        }
        
        return result;
    }
    
    public void restoreIpAddressesHelper(char[] str, int begin, StringBuilder sb, int numLeft, List<String> result) {
        if (numLeft == 0 && begin == str.length) {
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        } else if (numLeft == 0 || begin == str.length) {
            return;
        }
            
        for (int i = 1; i <=3 && begin + i <= str.length; i++) {
            int num = Integer.parseInt(new String(str, begin, i));
            if (num > 255 || num != 0 && str[begin] == '0' || num == 0 && i != 1)
                continue;
            int idx = sb.length();
            sb.append(num);
            sb.append('.');
            restoreIpAddressesHelper(str, begin+i, sb, numLeft-1, result);
            sb.delete(idx, sb.length());
        }
    }
}