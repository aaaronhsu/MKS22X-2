import java.util.*;
import java.io.*;

public class MazeGeneratorDriver {
  public static void writeMaze(int x, int y) throws FileNotFoundException {
    char[][] maze = new char[x][y];

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        maze[i][j] = '#';
      }
    }
    
    MazeGenerator.generateAmazing(maze, x, y, 1, 1);

    PrintWriter out = new PrintWriter(new File("maze.dat"));
    
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[0].length; j++) {
        out.print(maze[i][j]);
      }

      if (i != maze.length - 1) out.println();
    }

    out.close();
  }
}
