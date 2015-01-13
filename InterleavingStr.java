public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;

		boolean[] table = new boolean[s2.length()+1];
		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length() && j == s2.length()) {
					table[j] = true;
				} else if (i == s1.length()) {
					table[j] = s2.charAt(j) == s3.charAt(i+j) ? table[j+1] : false;
				} else if (j == s2.length()) {
					table[j] = s1.charAt(i) == s3.charAt(i+j) ? table[j] : false;
				} else {
					if (s1.charAt(i) == s3.charAt(i+j) && s2.charAt(j) == s3.charAt(i+j))
						table[j] = table[j] || table[j+1];
					else if (s1.charAt(i) == s3.charAt(i+j))
						table[j] = table[j];
					else if (s2.charAt(j) == s3.charAt(i+j))
						table[j] = table[j+1];
					else
						table[j] = false;
				}
			}
		}
		return table[0];
	}
}
