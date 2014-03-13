public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidGroup(board, i, 0, i, 8) || !isValidGroup(board, 0, i, 8, i)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidGroup(board, i, j, i+2, j+2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidGroup(char[][] board, int x0, int y0, int x1, int y1) {
        Set<Character> set = new HashSet<Character>();
        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return true;
    }
}
