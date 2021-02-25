import java.util.*;
import java.io.*;

public class Maze {
  public static void main(String[] args) {
    
    char[][] board = new char[0][0];
    try {
      board = readBoard("input.in");
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    solve(board);
    int ans = 0;
    for (char[]i : board) {
      for (char a : i) {
        if (a == '@') ans++;
      }
    }
    for (char[] i : board) System.out.println(Arrays.toString(i));

    System.out.println(ans);
  }
  
  public static char[][] readBoard(String f) throws FileNotFoundException {
    Scanner in = new Scanner(new File(f));

    ArrayList<char[]> l = new ArrayList<>();

    while (in.hasNextLine()) l.add(in.nextLine().toCharArray());

    char[][] board = new char[l.size()][];

    for (int i = 0; i < l.size(); i++) board[i] = l.get(i);

    return board;
  }

  public static void solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'S') System.out.println(solve(board, i, j) - 1);
      }
    }
  }

  // public static boolean solve(char[][] board, int x, int y) {
  //   if (board[x][y] == '#' || board[x][y] == '@' || board[x][y] == '.') return false;
  //   //        wall                curr search              seen
  //   if (board[x][y] == 'E') return true;

  //   board[x][y] = '@';

  //   boolean solution = solve(board, x + 1, y) || solve(board, x - 1, y) || solve(board, x, y + 1) || solve(board, x, y - 1);
    
  //   if (!solution) board[x][y] = '.';

  //   return solution;

  // }

  public static int solve(char[][] board, int x, int y) {
    if (board[x][y] == '#' || board[x][y] == '@' || board[x][y] == '.') return 0;
    //        wall                curr search              seen
    if (board[x][y] == 'E') return 1;

    board[x][y] = '@';

    int solution = solve(board, x + 1, y) + solve(board, x - 1, y) + solve(board, x, y + 1) + solve(board, x, y - 1);

    if (solution <= 0) {
      board[x][y] = '.';
      return solution;
    }

    return solution + 1;
  }
}
