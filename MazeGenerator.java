import java.util.*;
import java.io.*;

public class MazeGenerator {
  public static void generate(char[][] maze, int rows, int cols, int startrow, int startcol) {
    generateMaze(maze, startrow, startcol);

    maze[startrow][startcol] = 'S';

    boolean placedE = false;
    while (!placedE) {
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (maze[i][j] == ' ' && Math.random() < (1 / Math.pow((rows * cols), 0.9))) {
            maze[i][j] = 'E';
            placedE = true;
            break;
          }
        }
        if (placedE) break;
      }
    }
    
  }

  private static void generateMaze(char[][] maze, int x, int y) {
    if (x <= 0 || x >= maze.length - 1 || y <= 0 || y >= maze.length - 1) return;

    int adjacentCarvedRegions = 0;
    if (maze[x + 1][y] == ' ') adjacentCarvedRegions++;
    if (maze[x - 1][y] == ' ') adjacentCarvedRegions++;
    if (maze[x][y + 1] == ' ') adjacentCarvedRegions++;
    if (maze[x][y - 1] == ' ') adjacentCarvedRegions++;

    if (adjacentCarvedRegions >= 2) return;

    maze[x][y] = ' ';

    ArrayList<Integer> order = new ArrayList<>();
    order.add(1);
    order.add(2);
    order.add(3);
    order.add(4);
    Collections.shuffle(order);
    
    for (int i : order) {
      if (i == 1) generateMaze(maze, x + 1, y);
      if (i == 2) generateMaze(maze, x - 1, y);
      if (i == 3) generateMaze(maze, x, y + 1);
      if (i == 4) generateMaze(maze, x, y - 1);
    }
  }
}
