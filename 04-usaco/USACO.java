import java.util.*;
import java.io.*;

public class USACO {
  
  public static int bronze(String f) {
    Scanner in = new Scanner(System.in);
    try {
      in = new Scanner(new File(f));
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    int x = in.nextInt();
    int y = in.nextInt();
    int depth = in.nextInt();
    int n = in.nextInt();
    int[][] board = new int[x][y];

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        board[i][j] = in.nextInt();
      }
    }

    for (int i = 0; i < n; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      int stomps = in.nextInt();

      int max = -1;
      for (int c = a; c < a + 3; c++) {
        for (int d = b; d < b + 3; d++) {
          if (c >= x || d >= y) continue;
          max = Integer.max(max, board[c][d]);
        }
      }

      for (int c = a; c < a + 3; c++) {
        for (int d = b; d < b + 3; d++) {
          if (c >= x || d >= y) continue;
          board[c][d] = max - stomps < board[c][d] ? max - stomps : board[c][d];
        }
      }
    }

    int ans = 0;

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        ans += 0 < board[i][j] && board[i][j] < depth ? depth - board[i][j] : 0;
      }
    }

    return ans * 5184;
  }

  public static long silver(String f) {
    Scanner in = new Scanner(System.in);
    try {
      in = new Scanner(new File(f));
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    int x = in.nextInt();
    int y = in.nextInt();
    int steps = in.nextInt();

    int[][] dp = new int[x][y];

    boolean[][] board = new boolean[x][y];
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
          if (board[j][k]) fill(temp, j, k, dp, board);
        }
      }

      dp = temp;
    }

    return dp[in.nextInt() - 1][in.nextInt() - 1];
  }

  private static void fill(int[][] temp, int x, int y, int[][] dp, boolean[][] board) {
    if (x + 1 >= 0 && x + 1 < temp.length && y >= 0 && y < temp[0].length && board[x + 1][y]) temp[x][y] += dp[x + 1][y];
    if (x - 1 >= 0 && x - 1 < temp.length && y >= 0 && y < temp[0].length && board[x - 1][y]) temp[x][y] += dp[x - 1][y];
    if (x >= 0 && x < temp.length && y + 1 >= 0 && y + 1 < temp[0].length && board[x][y + 1]) temp[x][y] += dp[x][y + 1];
    if (x >= 0 && x < temp.length && y - 1 >= 0 && y - 1 < temp[0].length && board[x][y - 1]) temp[x][y] += dp[x][y - 1];
  }
}
