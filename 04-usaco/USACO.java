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
  }

  public static long silver(String f) throws FileNotFoundException {
    Scanner in = new Scanner(new File(f));
  }
}
