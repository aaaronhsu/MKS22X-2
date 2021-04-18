import java.util.*;
public class BurnTreesXY {
  private int[][]map;
  private int ticks;
  private static int TREE = 2;
  private static int FIRE = 1;
  private static int ASH = 3;
  private static int SPACE = 0;

  private ArrayDeque<Integer> toBurnX;
  private ArrayDeque<Integer> toBurnY;

  private long memory = 0;

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();

      memory = Long.max(memory, Runtime.getRuntime().totalMemory()-
      Runtime.getRuntime().freeMemory());
    }

    System.out.println(memory);
    return getTicks();
  }

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTreesXY(int width,int height, double density){
    map = new int[height][width];
    toBurnX = new ArrayDeque<Integer>();
    toBurnY = new ArrayDeque<Integer>();
    for(int r=0; r<map.length; r++ )
      for(int c=0; c<map[r].length; c++ )
        if(Math.random() < density)
           map[r][c]=2;
    start();//set the left column on fire.
  }

  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS

    return toBurnX.isEmpty();
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;
    //YOU MUST IMPLEMENT THIS
    ArrayDeque<Integer> burnNextX = new ArrayDeque<>();
    ArrayDeque<Integer> burnNextY = new ArrayDeque<>();

    while (!toBurnX.isEmpty()) {
      int burnX = toBurnX.poll();
      int burnY = toBurnY.poll();

      map[burnX][burnY] = ASH;

      if (burnX + 1 < map.length && map[burnX + 1][burnY] == TREE) {
        burnNextX.add(burnX + 1);
        burnNextY.add(burnY);
        map[burnX + 1][burnY] = FIRE;
      }
      if (burnX - 1 >= 0 && map[burnX - 1][burnY] == TREE) {
        burnNextX.add(burnX - 1);
        burnNextY.add(burnY);
        map[burnX - 1][burnY] = FIRE;
      }
      if (burnY + 1 < map[0].length && map[burnX][burnY + 1] == TREE) {
        burnNextX.add(burnX);
        burnNextY.add(burnY + 1);
        map[burnX][burnY + 1] = FIRE;
      }
      if (burnY - 1 >= 0 && map[burnX][burnY - 1] == TREE) {
        burnNextX.add(burnX);
        burnNextY.add(burnY - 1);
        map[burnX][burnY - 1] = FIRE;
      }
    }

    toBurnX = burnNextX;
    toBurnY = burnNextY;
  }

  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;

        toBurnX.add(i);
        toBurnY.add(0);
      }
    }
  }





  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }
  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }


  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


  public static void main(String[]args)  throws InterruptedException{
    int WIDTH = 100000;
    int HEIGHT = 100000;
    int DELAY = 50;
    double DENSITY = 1;
    if(args.length > 1){
      WIDTH = Integer.parseInt(args[0]);
      HEIGHT = Integer.parseInt(args[1]);
      DENSITY = Double.parseDouble(args[2]);
    }
    if(args.length > 3){
      DELAY = Integer.parseInt(args[3]);
    }
    BurnTreesXY b = new BurnTreesXY(WIDTH,HEIGHT,DENSITY);

    b.run();


    // System.out.println(b.animate(DELAY));//animate all screens and print the final answer
    //System.out.println(b.outputAll());//print all screens and the final answer
  }


}
