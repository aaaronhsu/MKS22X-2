public class QueenBoard {
	private int[][] board;

	public QueenBoard(int size) {
		board = new int[size][size];
	}

	public String toString() {
		String ret = "";
		for (int row = 0; row < board.length; row++) {
			String hold = "";
			for (int space = 0; space < board[row].length; space++) {
				hold += board[row][space] == -1 ? "Q" : "_";
				if (space != board[row].length - 1) hold += " ";
				else if (row != board.length - 1) hold += "\n";
			}
			ret += hold;
		}
		
		return ret;
	}

	private boolean addQueen(int r, int c) {
		if (board[r][c] == 0) {
			board[r][c] = -1;
			return true;
		}
		return false;
	}

	private void removeQueen(int r, int c) {
		board[r][c] = 0;
	}
}