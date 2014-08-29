public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
            
        char[] str = s.toCharArray();
        char[][] grid = new char[nRows][str.length];
        
        int x = 0, y = 0, dx = 1, dy = 0;
        for (int i = 0; i < str.length; i++) {
            grid[x][y] = str[i];
            if (x + dx == nRows) {
                dx = -1;
                dy = 1;
            } else if (x + dx < 0) {
                dx = 1;
                dy = 0;
            }
            
            x += dx;
            y += dy;
        }
        
        int w = 0;
        for (int i = 0; i < nRows; i++)
            for (int j = 0; j < str.length; j++)
                if (grid[i][j] != 0)
                    str[w++] = grid[i][j];
                    
        return new String(str);
    }
}