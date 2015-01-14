public class Solution {
    public boolean precheck(String s, String p) {
        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        Map<Character, Integer> mapP = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++)
            mapS.put(s.charAt(i), mapS.containsKey(s.charAt(i)) ? mapS.get(s.charAt(i))+1 : 1);
        for (int i = 0; i < p.length(); i++)
            if (p.charAt(i) != '?' && p.charAt(i) != '*')
                mapP.put(p.charAt(i), mapP.containsKey(p.charAt(i)) ? mapP.get(p.charAt(i))+1 : 1);
        for (char ch : mapP.keySet())
            if (!mapS.containsKey(ch) || mapP.get(ch) > mapS.get(ch))
                return false;
        return true;
    }
    
    public boolean isMatch(String s, String p) {
        if (!precheck(s, p))
            return false;
        boolean[] table = new boolean[s.length()+1];
        for (int i = 0; i < s.length(); i++)
            table[i] = false;
        table[table.length-1] = true;
        for (int j = p.length()-1; j >= 0; j--) {
            for (int i = 0; i < s.length(); i++) {
                switch (p.charAt(j)) {
                case '?':
                    table[i] = table[i+1];
                    break;
                case '*':
                    if (j == p.length()-1) {
                        table[i] = true;
                    } else if (p.charAt(j+1) == '*') {
                        table[i] = table[i];
                    } else if (p.charAt(j+1) == '?') {
                        for (int k = i+1; k <= s.length(); k++)
                            table[i] = table[i] || table[k];
                    } else {
                        table[i] = s.charAt(i) == p.charAt(j+1) ? table[i] : false;
                        for (int k = i+1; k < s.length(); k++)
                            if (s.charAt(k) == p.charAt(j+1))
                                table[i] = table[i] || table[k];
                    }
                    break;
                default:
                    table[i] = s.charAt(i) == p.charAt(j) && table[i+1];
                    break;
                }
            }
            table[table.length-1] = table[table.length-1] && p.charAt(j) == '*';
        }
        return table[0];
    }
}