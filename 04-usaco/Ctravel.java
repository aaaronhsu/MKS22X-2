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

    int[][] dp = new int[x][y];

    board = new boolean[x][y];
    for (int i = 0; i < x; i++) {
      String row = in.next();
      for (int j = 0; j < y; j++) {
        board[i][j] = row.charAt(j) == '.' ? true : false;
      }
    }

    dp[in.nextInt() - 1][in.nextInt() - 1]++;

    for (int i = 0; i < steps; i++) {
      int[][] temp = new int[x][y];

      for (int j = 0; j < x; j++) {
        for (int k = 0; k < y; k++) {
          if (board[j][k]) fill(temp, j, k, dp);
        }
      }

      dp = temp;
    }
    
    out.println(dp[in.nextInt() - 1][in.nextInt() - 1]);
    out.close();
	}

  public static int[][] clone(int[][] arr) {
    int[][] ret = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) ret[i] = arr[i].clone();
    return ret;
  }

  public static void fill(int[][] temp, int x, int y, int[][] dp) {
    if (x + 1 >= 0 && x + 1 < temp.length && y >= 0 && y < temp[0].length && board[x + 1][y]) temp[x][y] += dp[x + 1][y];
    if (x - 1 >= 0 && x - 1 < temp.length && y >= 0 && y < temp[0].length && board[x - 1][y]) temp[x][y] += dp[x - 1][y];
    if (x >= 0 && x < temp.length && y + 1 >= 0 && y + 1 < temp[0].length && board[x][y + 1]) temp[x][y] += dp[x][y + 1];
    if (x >= 0 && x < temp.length && y - 1 >= 0 && y - 1 < temp[0].length && board[x][y - 1]) temp[x][y] += dp[x][y - 1];
  }
}