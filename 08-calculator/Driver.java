import java.util.ArrayDeque;

public class Driver {
  public static void main(String[] args) {
    
    String str = "1 1 + 1 1 + 1 1 1 - * + 1 + 1 + +";
    System.out.println(Calculator.eval(str));
  }
}
