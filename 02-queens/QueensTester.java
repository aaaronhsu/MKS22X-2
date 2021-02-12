public class QueensTester {
	public static void main(String[] args) {
		for (int i = 0; i <= 8; i++) {
			QueenBoard board = new QueenBoard(i);

			System.out.println(board.countSolutions());
			System.out.println(board.solve());
			System.out.println(board);
			System.out.println();
		}
	}
}