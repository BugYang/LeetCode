public class Solution {
	public char CLOSE = 'X';
	public char UNCHECKED = 'O';
	public char OPEN = 'C';

	public void solve(char[][] board) {
		if (board.length == 0)
			return;
		Stack<Point> stack = new Stack<Point>();

		// search boundary
		for (int i = 0; i < board[0].length; i++) {
			checkPoint(board, 0, i, stack);
			checkPoint(board, board.length-1, i, stack);
		}
		for (int i = 0; i < board.length; i++) {
			checkPoint(board, i, 0, stack);
			checkPoint(board, i, board[0].length-1, stack);
		}

		while (!stack.empty()) {
			Point point = stack.pop();
			int x = point.x;
			int y = point.y;
			checkPoint(board, x-1, y, stack);
			checkPoint(board, x, y-1, stack);
			checkPoint(board, x, y+1, stack);
			checkPoint(board, x+1, y, stack);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == OPEN)
					board[i][j] = 'O';
				else
					board[i][j] = 'X';
			}
		}
	}

	public void checkPoint(char[][] board, int x, int y, Stack<Point> stack) {
		if (0 <= x && x < board.length && 0 <= y && y < board[x].length) {
			if (board[x][y] == UNCHECKED) {
				board[x][y] = OPEN;
				stack.push(new Point(x, y));
			}
		}
	}
}

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
