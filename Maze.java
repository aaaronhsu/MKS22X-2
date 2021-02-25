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
    for (char[] i : board) System.out.println(Arrays.toString(i));
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
        if (board[i][j] == 'S') solve(board, i, j);
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '*' || board[i][j] == '.') board[i][j] = ' ';
      }
    }
  }

  public static boolean solve(char[][] board, int x, int y) {
    if (board[x][y] == '#' || board[x][y] == '*' || board[x][y] == '.') return false;
    //        wall                curr search              seen
    if (board[x][y] == 'E') return true;

    board[x][y] = '*';

    boolean solution = solve(board, x + 1, y) || solve(board, x - 1, y) || solve(board, x, y + 1) || solve(board, x, y - 1);
    
    if (solution) {
      board[x][y] = '@';
      return true;
    }

    board[x][y] = '.';
    return false;

  }
}
