import java.util.*;
import java.io.*;

public class MazeGenerator {

  static ArrayList<int[]> empty = new ArrayList<>();

  public static void generate(char[][] maze, int rows, int cols, int startrow, int startcol) {
    empty = new ArrayList<>();
    generateMaze(maze, startrow, startcol);

    maze[startrow][startcol] = 'S';
    int[] endPos = empty.get((int) (Math.random() * empty.size()));
    maze[endPos[0]][endPos[1]] = 'E';
  }

  private static void generateMaze(char[][] maze, int x, int y) {
    if (x <= 0 || x >= maze.length - 1 || y <= 0 || y >= maze[0].length - 1) return;

    int adjacentCarvedRegions = 0;
    if (maze[x + 1][y] != '#') adjacentCarvedRegions++;
    if (maze[x - 1][y] != '#') adjacentCarvedRegions++;
    if (maze[x][y + 1] != '#') adjacentCarvedRegions++;
    if (maze[x][y - 1] != '#') adjacentCarvedRegions++;

    if (adjacentCarvedRegions >= 2) return;

    maze[x][y] = ' ';
    empty.add(new int[] {x, y});

    ArrayList<Integer> order = new ArrayList<>();
    order.add(1);
    order.add(2);
    order.add(3);
    order.add(4);
    Collections.shuffle(order);
    
    for (int i : order) {
      if (i == 1) generateMaze(maze, x + 1, y);
      else if (i == 2) generateMaze(maze, x - 1, y);
      else if (i == 3) generateMaze(maze, x, y + 1);
      else generateMaze(maze, x, y - 1);
    }
  }


}
