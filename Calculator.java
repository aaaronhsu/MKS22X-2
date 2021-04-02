import java.util.ArrayDeque;

import java.util.*;
import java.io.*;

public class Calculator {
  public static double eval(String s) {
    if (s.length() == 0) throw new IllegalArgumentException();

    ArrayDeque<Double> stack = new ArrayDeque<>();
    
    Scanner in = new Scanner(s);

    while (in.hasNext()) {
      String str = in.next();

      try {
        stack.add(Double.parseDouble(str));
      }
      catch (NumberFormatException e) {
        if (stack.size() <= 1) throw new IllegalArgumentException("too many operands");
        
        Double hold = stack.pollLast();

        if (str.equals("+")) stack.add(stack.pollLast() + hold);
        else if (str.equals("-")) stack.add(stack.pollLast() - hold);
        else if (str.equals("/")) stack.add(stack.pollLast() / hold);
        else if (str.equals("*")) stack.add(stack.pollLast() * hold);
        else if (str.equals("%")) stack.add(stack.pollLast() % hold);
        else throw new IllegalArgumentException("not a valid operator");
      }
    }

    if (stack.size() != 1) throw new IllegalArgumentException("too few operands");

    return stack.poll();
  }
}
