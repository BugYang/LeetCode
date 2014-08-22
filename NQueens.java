public class Solution {
	public List<String[]> solveNQueens(int n) {
		List<String[]> solutions = new LinkedList<String[]>();
		int[] board = new int[n];

		solveNQueensHelper(n, board, solutions);

		return solutions;
	}

	public String[] genSolution(int[] board) {
		String[] solution = new String[board.length];
		char[] str = new char[board.length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++)
				str[j] = '.';
			str[board[i]] = 'Q';
			solution[i] = new String(str);
		}

		return solution;
	}

	public void solveNQueensHelper(int n, int[] board, List<String[]> solutions) {
		if (n == 0) {
			solutions.add(genSolution(board));
			return;
		}

		for (int i = 0; i < board.length; i++) {
			boolean fit = true;
			for (int j = n; j < board.length; j++) {
				if (i == board[j])
					fit = false;
				if (n - 1 - j == i - board[j])
					fit = false;
				if (n - 1 - j == board[j] - i)
					fit = false;
			}
			if (fit) {
				board[n - 1] = i;
				solveNQueensHelper(n - 1, board, solutions);
			}
		}
	}
}
