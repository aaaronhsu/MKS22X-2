import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static int TREE = 2;
  private static int FIRE = 1;
  private static int ASH = 3;
  private static int SPACE = 0;

  private ArrayDeque<int[]> toBurn;

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
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    toBurn = new ArrayDeque<>();
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

    return toBurn.isEmpty();
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;
    //YOU MUST IMPLEMENT THIS
    ArrayDeque<int[]> burnNext = new ArrayDeque<>();

    while (!toBurn.isEmpty()) {
      int[] burn = toBurn.poll();

      map[burn[0]][burn[1]] = ASH;

      if (burn[0] + 1 < map.length && map[burn[0] + 1][burn[1]] == TREE) {
        burnNext.add(new int[] {burn[0] + 1, burn[1]});
        map[burn[0] + 1][burn[1]] = FIRE;
      }
      if (burn[0] - 1 >= 0 && map[burn[0] - 1][burn[1]] == TREE) {
        burnNext.add(new int[] {burn[0] - 1, burn[1]});
        map[burn[0] - 1][burn[1]] = FIRE;
      }
      if (burn[1] + 1 < map[0].length && map[burn[0]][burn[1] + 1] == TREE) {
        burnNext.add(new int[] {burn[0], burn[1] + 1});
        map[burn[0]][burn[1] + 1] = FIRE;
      }
      if (burn[1] - 1 >= 0 && map[burn[0]][burn[1] - 1] == TREE) {
        burnNext.add(new int[] {burn[0], burn[1] - 1});
        map[burn[0]][burn[1] - 1] = FIRE;
      }
    }

    toBurn = burnNext;
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

        toBurn.add(new int[] {i, 0});
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
    int WIDTH = 1000;
    int HEIGHT = 1000;
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
    BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);

    b.run();


    // System.out.println(b.animate(DELAY));//animate all screens and print the final answer
    //System.out.println(b.outputAll());//print all screens and the final answer
  }


}
