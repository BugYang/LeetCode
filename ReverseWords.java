public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";

        int begin, end = 0;
        ArrayList<String> words = new ArrayList<String>();
        // tokenize
        while (end < s.length()) {
            begin = end;
            end = begin + 1;
            
            // find next range
            if (Character.isWhitespace(s.charAt(begin))) {
                while (end < s.length() && Character.isWhitespace(s.charAt(end)))
                    end++;
            } else {
                while (end < s.length() && !Character.isWhitespace(s.charAt(end)))
                    end++;
                words.add(s.substring(begin, end));
            }
        }
        
        if (words.size() == 0)
            return "";
            
        StringBuilder sb = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i));
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}