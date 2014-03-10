public class Solution {
    public int totalNQueens(int n) {
        int[] sol = new int[n];
        return totalNQueensHelper(sol, 0, n);
    }

    public int totalNQueensHelper(int[] sol, int place, int size) {
        if (place == size) {
            return 1;
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            sol[place] = i;
            if (isValidQueen(sol, place)) {
                result += totalNQueensHelper(sol, place+1, size);
            }
        }
        return result;
    }

    public boolean isValidQueen(int[] sol, int place) {
        for (int i = 0; i < place; i++) {
            if (sol[place] == sol[i] || (sol[place]-sol[i]) == (place-i) || (sol[place]-sol[i]) == (i-place)) {
                return false;
            }
        }
        return true;
    }
}
