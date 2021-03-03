import java.util.*;
import java.io.*;

public class Ctravel {
	static int ans = 0;
  static boolean[][] board;
  static int endX, endY;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("ctravel.in"));
    PrintWriter out = new PrintWriter(new File("ctravel.out"));
		
    int x = in.nextInt();
    int y = in.nextInt();
    int steps = in.nextInt();

    board = new boolean[x][y];
    for (int i = 0; i < x; i++) {
      String row = in.next();
      for (int j = 0; j < y; j++) {
        board[i][j] = row.charAt(j) == '.' ? true : false;
      }
    }
    endX = in.nextInt() - 1;
    endY = in.nextInt() - 1;

    out.println(dfs(in.nextInt() - 1, in.nextInt() - 1, steps));
    out.close();
	}

  public static int dfs(int x, int y, int stepsL) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || !board[x][y]) return 0;
    if (stepsL == 0) return x == endX && y == endY ? 1 : 0;

    return 
      dfs(x + 1, y, stepsL - 1) +
      dfs(x - 1, y, stepsL - 1) +
      dfs(x, y + 1, stepsL - 1) +
      dfs(x, y - 1, stepsL - 1);
  }
}