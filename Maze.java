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

    ArrayList<char[]> l = new ArrayList<>();

    while (in.hasNextLine()) l.add(in.nextLine().toCharArray());

    char[][] board = new char[l.size()][];

    for (int i = 0; i < l.size(); i++) board[i] = l.get(i);

    return board;
  }
}
