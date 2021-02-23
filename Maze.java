import java.io.FileNotFoundException;

import java.util.*;
import java.io.*;

public class Maze {
  public static void main(String[] args) {
    
    try {
      System.out.println(Arrays.deepToString(readBoard("input.in")));
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static char[][] readBoard(String f) throws FileNotFoundException {
    Scanner in = new Scanner(new File(f));
    int row = 0;

    while (in.hasNextLine()) {
      row++;
      in.nextLine();
    }

    char[][] board = new char[row][];
    in = new Scanner(new File(f));

    row = 0;

    while (in.hasNextLine()) {
      board[row] = in.nextLine().toCharArray();
      row++;
    }

    return board;
  }
}
