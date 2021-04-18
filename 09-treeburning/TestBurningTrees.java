public class TestBurningTrees{
  public static int runTest(BurnTreesXY[]allTests){
    int total = 0;
    for(BurnTreesXY b : allTests){
      total += b.run();
    }
    return total / allTests.length;
  }


  public static void timeTest(int size, double density, int trials){
    //avoid displaying insignificant digits and rounding error nonsense.
    BurnTreesXY b[] = new BurnTreesXY[trials];
    for(int i =0 ; i < b.length; i++){
      b[i] = new BurnTreesXY(size,size,density);
    }
    System.out.print("Steps = ");
    long start = System.currentTimeMillis();
    System.out.print(runTest(b)+"\t");
    System.out.println( (System.currentTimeMillis()-start)/1000.0+" sec");

  }

  public static void main(String[]args){
    int SIZE = 500;
    int TRIALS = 50;
    double DENSITY = 0.6;
    if(args.length>0)SIZE=Integer.parseInt(args[0]);
    if(args.length>1)TRIALS=Integer.parseInt(args[1]);
    if(args.length>2)DENSITY=Double.parseDouble(args[2]);
    System.out.print("Size = "+SIZE);
    System.out.print( "\tTrials = "+TRIALS);
    System.out.print("\tDensity = "+Math.round(DENSITY*1000.0)/1000.0+"\t");
    timeTest(SIZE,DENSITY,TRIALS);
  }
}