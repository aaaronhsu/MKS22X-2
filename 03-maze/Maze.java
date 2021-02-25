import java.util.*;
import java.io.*;

public class Maze {
  private char[][] maze;
  private boolean animate;
  
  public Maze(String filename) throws FileNotFoundException {
    Scanner in = new Scanner(new File(f));

    ArrayList<char[]> l = new ArrayList<>();

    while (in.hasNextLine()) l.add(in.nextLine().toCharArray());

    maze = new char[l.size()][];

    for (int i = 0; i < l.size(); i++) maze[i] = l.get(i);
  }

  
}
