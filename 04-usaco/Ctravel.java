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

    int[][] ans = new int[x][y];

    board = new boolean[x][y];
    for (int i = 0; i < x; i++) {
      String row = in.next();
      for (int j = 0; j < y; j++) {
        board[i][j] = row.charAt(j) == '.' ? true : false;
      }
    }

    ans[in.nextInt() - 1][in.nextInt() - 1]++;

    for (int i = 0; i < steps; i++) {
      int[][] temp = clone(ans);
      System.out.println(1);

      for (int j = 0; j < x; j++) {
        for (int k = 0; k < y; k++) {
          if (temp[j][k] > 0) fill(ans, j, k);
        }
      }
    }
    
    out.println(ans[in.nextInt() - 1][in.nextInt() - 1]);
    out.close();

    for (int[] i : ans) System.out.println(Arrays.toString(i));
	}

  public static int[][] clone(int[][] arr) {
    int[][] ret = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) ret[i] = arr[i].clone();
    return ret;
  }

  public static void fill(int[][] ans, int x, int y) {
    if (x + 1 >= 0 && x + 1 < ans.length && y >= 0 && y < ans[0].length && board[x + 1][y]) ans[x + 1][y]++;
    if (x - 1 >= 0 && x - 1 < ans.length && y >= 0 && y < ans[0].length && board[x - 1][y]) ans[x - 1][y]++;
    if (x >= 0 && x < ans.length && y + 1 >= 0 && y + 1 < ans[0].length && board[x][y + 1]) ans[x][y + 1]++;
    if (x >= 0 && x < ans.length && y - 1 >= 0 && y - 1 < ans[0].length && board[x][y - 1]) ans[x][y - 1]++;
  }
}