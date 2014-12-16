public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (existHelper(board, i, j, word, 0, new HashSet<Long>()))
                    return true;
        return false;
    }
    
    public boolean existHelper(char[][] board, int x, int y, String word, int idx, HashSet<Long> path) {
        long key = ((long)x << 32) | (long)y;
        if (path.contains(key) || board[x][y] != word.charAt(idx))
            return false;
        if (idx == word.length()-1)
            return true;
            
        path.add(key);
        if (x-1 >= 0 && existHelper(board, x-1, y, word, idx+1, path))
            return true;
        if (y-1 >= 0 && existHelper(board, x, y-1, word, idx+1, path))
            return true;
        if (x+1 < board.length && existHelper(board, x+1, y, word, idx+1, path))
            return true;
        if (y+1 < board[0].length && existHelper(board, x, y+1, word, idx+1, path))
            return true;
        path.remove(key);
        return false;
    }
}