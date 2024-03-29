import java.util.*;
import java.io.*;

public class Maze {
  private char[][] maze;
  private boolean animate;
  
  public Maze(String filename) throws FileNotFoundException {
    Scanner in = new Scanner(new File(filename));

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

  public String toString() {
    String ret = "";

    for (char[] i : maze) {
      for (char a : i) ret += a;
      ret += "\n";
    }

    return ret.substring(0, ret.length() - 1);
  }

  public int solve() {
    if (animate) clearTerminal();

    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[0].length; j++) {
        if (maze[i][j] == 'S') return solve(i, j) - 1;
      }
    }

    return 0;
  }

  private int solve(int x, int y) {
    if (animate) {
      gotoTop();
      System.out.println(this);
      wait(3);
    }

    if (maze[x][y] == '#' || maze[x][y] == '@' || maze[x][y] == '.') return 0;
    //        wall                curr search              seen
    if (maze[x][y] == 'E') return 1;

    maze[x][y] = '@';

    int nextSteps = solve(x + 1, y);
    if (nextSteps > 0) return nextSteps + 1;

    nextSteps = solve(x - 1, y);
    if (nextSteps > 0) return nextSteps + 1;

    nextSteps = solve(x, y + 1);
    if (nextSteps > 0) return nextSteps + 1;

    nextSteps = solve(x, y - 1);
    if (nextSteps > 0) return nextSteps + 1;

    maze[x][y] = '.';
    return 0;
  }

  
}
