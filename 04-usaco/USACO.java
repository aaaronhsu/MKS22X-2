import java.util.*;
import java.io.*;

public class USACO {
  
  public static int bronze(String f) throws FileNotFoundException {
    Scanner in = new Scanner(new File(f));

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

  public static long silver(String f) throws FileNotFoundException {
    Scanner in = new Scanner(new File(f));
  }
}
