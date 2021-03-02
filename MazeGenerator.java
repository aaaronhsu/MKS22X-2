import java.util.*;
import java.io.*;

public class MazeGenerator {

  static int[] farthestSpace;

  public static void generate(char[][] maze, int rows, int cols, int startrow, int startcol) {
    farthestSpace = new int[] {0, startrow, startcol};
    generateMaze(maze, startrow, startcol, 0);

    maze[startrow][startcol] = 'S';
    maze[farthestSpace[1]][farthestSpace[2]] = 'E';
  }

  private static void generateMaze(char[][] maze, int x, int y, int dist) {
    if (x <= 0 || x >= maze.length - 1 || y <= 0 || y >= maze[0].length - 1) return;

    int adjacentCarvedRegions = 0;
    if (maze[x + 1][y] != '#') adjacentCarvedRegions++;
    if (maze[x - 1][y] != '#') adjacentCarvedRegions++;
    if (maze[x][y + 1] != '#') adjacentCarvedRegions++;
    if (maze[x][y - 1] != '#') adjacentCarvedRegions++;

    if (adjacentCarvedRegions >= 2) return;

    maze[x][y] = ' ';
    
    if (dist > farthestSpace[0]) {
      farthestSpace = new int[] {dist, x, y};
    }

    ArrayList<Integer> order = new ArrayList<>();
    order.add(1);
    order.add(2);
    order.add(3);
    order.add(4);
    Collections.shuffle(order);
    
    for (int i : order) {
      if (i == 1) generateMaze(maze, x + 1, y, dist + 1);
      else if (i == 2) generateMaze(maze, x - 1, y, dist + 1);
      else if (i == 3) generateMaze(maze, x, y + 1, dist + 1);
      else generateMaze(maze, x, y - 1, dist + 1);
    }
  }
}
