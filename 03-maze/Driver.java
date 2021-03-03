import java.io.FileNotFoundException;

public class Driver {
  public static void main(String[] args) {

    try {
      MazeGeneratorDriver.writeMaze(50, 100);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    String filename = "maze.dat";
    try{
      Maze f;
      f = new Maze(filename);//true animates the maze.

      f.setAnimate(true);//comment this if you are using windows cmd/powershell
      System.out.println(f.solve()+" steps");
      System.out.println(f);
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+filename);
    }
  }
}