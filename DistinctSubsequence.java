public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null)
            return 0;
        int lens = S.length(), lent = T.length();
        int[][] cnt = new int[lens+1][lent+1];
        
        for (int i = 0; i <= lent; i++)
            cnt[0][i] = 0;
        for (int i = 0; i <= lens; i++)
            cnt[i][0] = 1;

        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lent; j++) {
                cnt[i][j] = cnt[i-1][j];
                if (S.charAt(i-1) == T.charAt(j-1))
                    cnt[i][j] += cnt[i-1][j-1];
            }
        }
        
        return cnt[lens][lent];
    }
}