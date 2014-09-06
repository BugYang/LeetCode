public class Solution {
        public List<String> anagrams(String[] strs) {
                String[] hashes = new String[strs.length];
                HashMap<String, Integer> cnt = new HashMap<String, Integer>();
                List<String> result = new ArrayList<String>();

                for (int i = 0; i < strs.length; i++) {
                        hashes[i] = getHash(strs[i]);
                        cnt.put(hashes[i], cnt.containsKey(hashes[i]) ? cnt.get(hashes[i])+1 : 1);
                }

                for (int i = 0; i < strs.length; i++)
                        if (cnt.get(hashes[i]) > 1)
                                result.add(strs[i]);

                return result;
        }

        public String getHash(String key) {
                char[] hash = new char[26], str = key.toCharArray();
                for (int i = 0; i < str.length; i++)
                        hash[str[i]-'a']++;
                return new String(hash);
        }
}
