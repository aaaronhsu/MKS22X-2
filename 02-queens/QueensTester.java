public class QueensTester {
	public static void main(String[] args) {
		QueenBoard board = new QueenBoard(8);

		board.solve();

		System.out.println(board);
	}
}