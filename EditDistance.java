public class Solution {
	public int minDistance(String word1, String word2) {
		int len1 = word1.length(), len2 = word2.length();
		int[][] dist = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++)
			dist[i][0] = i;
		for (int i = 0; i <= len2; i++)
			dist[0][i] = i;
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {                       
				// from dist[i-1, j]
				int del = dist[i-1][j] + 1;
				// from dist[i, j-1]
				int add = dist[i][j-1] + 1;
				// from dist[i-1, j-1]
				int chg = dist[i-1][j-1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1); 
				dist[i][j] = Math.min(Math.min(del, add), chg);
			}
		}           
		return dist[len1][len2];   
	}
}
