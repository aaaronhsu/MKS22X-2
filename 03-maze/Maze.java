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

  private void wait(int millis) {
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {}
  }

  public void setAnimate(boolean b) {
    animate = b;
  }

  public static void clearTerminal() {
    System.out.println("\033[2J");
  }

  public static void gotoTop() {
    System.out.println("\033[1;1H");
  }

  
}
