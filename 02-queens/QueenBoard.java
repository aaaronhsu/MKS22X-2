public class QueenBoard {
	private int[][] board;

	public QueenBoard(int size) {
		board = new int[size][size];
	}

	// public String toString() {
	// 	String ret = "";
	// 	for (int row = 0; row < board.length; row++) {
	// 		String hold = "";
	// 		for (int space = 0; space < board[row].length; space++) {
	// 			hold += board[row][space] == -1 ? "Q" : "_";
	// 			if (space != board[row].length - 1) hold += " ";
	// 			else if (row != board.length - 1) hold += "\n";
	// 		}
	// 		ret += hold;
	// 	}
		
	// 	return ret;
	// }

	public String toString() {
		String ret = "";
		for (int row = 0; row < board.length; row++) {
			String hold = "";
			for (int space = 0; space < board[row].length; space++) {
				hold += board[row][space];
				if (space != board[row].length - 1) hold += " ";
				else if (row != board.length - 1) hold += "\n";
			}
			ret += hold;
		}
		
		return ret;
	}

	private boolean addQueen(int r, int c) {
		if (board[r][c] == 0) {
			modify(r, c, 1);
			board[r][c] = -1;
			return true;
		}
		return false;
	}

	private void removeQueen(int r, int c) {
		modify(r, c, -1);
		board[r][c] = 0;
	}

	private void modify(int r, int c, int mod) {
		for (int i = c; i < board.length; i++) {
			board[r][i] += mod; // horizontal
			if (r + i - c < board.length) board[r + i - c][i] += mod; // bottom diag
			if (r - i + c >= 0) board[r - i + c][i] += mod; // top diag
		}
	}

	// public boolean solve() throws IllegalStateException {
		
	// }

	// private boolean solve(int col) {
	// 	if (col == board.length) return true;

	// 	for (int i = 0; i < board.length; i++) {
	// 		if (addQueen(i, col))
	// 	}
	// }
}