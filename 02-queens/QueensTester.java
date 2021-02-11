public class QueensTester {
	public static void main(String[] args) {
		QueenBoard board = new QueenBoard(8);

		System.out.println(board);
		System.out.println();

		board.addQueen(0, 0);

		System.out.println(board);
		System.out.println();

		board.addQueen(3, 4);
		System.out.println(board);
		System.out.println();

		board.removeQueen(0, 0);
		System.out.println(board);
		System.out.println();
	}
}