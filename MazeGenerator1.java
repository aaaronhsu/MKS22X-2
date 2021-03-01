import java.util.*;
import java.io.*;

public class MazeGenerator1 {
  public char[][] maze;

  public MazeGenerator1(int x, int y) {
    maze = new char[x][y];

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        maze[i][j] = '#';
      }
    }

    int startX = (int) (Math.random() * x);
    int startY = (int) (Math.random() * y);
    generateMaze(startX, startY);

    try {
      writeMaze();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public MazeGenerator1(int x, int y, double straightness) {
    maze = new char[x][y];

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        maze[i][j] = '#';
      }
    }

    int startX = (int) (Math.random() * x);
    int startY = (int) (Math.random() * y);

    generateMazeFancy(startX, startY, 0, straightness / 100);

    try {
      writeMaze();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public MazeGenerator1(int x, int y, double straightness, int go) {
    maze = new char[x][y];

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        maze[i][j] = '#';
      }
    }

    int startX = (int) (Math.random() * x);
    int startY = (int) (Math.random() * y);

    generateMazeFancy(startX, startY, 0, straightness / 100, go);

    try {
      writeMaze();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void generateMaze(int x, int y) {
    if (x == 0 || x == maze.length - 1 || y == 0 || y == maze.length - 1) return;

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
      if (i == 1) generateMaze(x + 1, y);
      if (i == 2) generateMaze(x - 1, y);
      if (i == 3) generateMaze(x, y + 1);
      if (i == 4) generateMaze(x, y - 1);
    }
  }

  public void generateMazeFancy(int x, int y, int dir, double straightness) {
    if (x == 0 || x == maze.length - 1 || y == 0 || y == maze.length - 1) return;

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

    if (Math.random() < straightness && dir != 0) {
      order.remove((Integer) dir);
      order.add(0, dir);
    }
    
    
    for (int i : order) {
      if (i == 1) generateMazeFancy(x + 1, y, 1, straightness);
      if (i == 2) generateMazeFancy(x - 1, y, 2, straightness);
      if (i == 3) generateMazeFancy(x, y + 1, 3, straightness);
      if (i == 4) generateMazeFancy(x, y - 1, 4, straightness);
    }
  }

  public void generateMazeFancy(int x, int y, int dir, double straightness, int go) {
    if (x == 0 || x == maze.length - 1 || y == 0 || y == maze.length - 1) return;

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


    int straight = 0;
    if (go > 0) {
      order.remove((Integer) dir);
      order.add(0, dir);
      straight = go - 1;
    }
    else {
      straight = (int) (Math.random() * straightness);
    }
    
    
    for (int i : order) {
      if (i == 1) generateMazeFancy(x + 1, y, 1, straightness, straight);
      if (i == 2) generateMazeFancy(x - 1, y, 2, straightness, straight);
      if (i == 3) generateMazeFancy(x, y + 1, 3, straightness, straight);
      if (i == 4) generateMazeFancy(x, y - 1, 4, straightness, straight);
    }
  }

  public void writeMaze() throws FileNotFoundException {
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