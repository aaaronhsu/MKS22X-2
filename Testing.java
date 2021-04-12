import java.util.*;
import java.io.*;

public class Testing {
	public static void main(String[] args) {
    Integer[] l = {1, 2, 3, 4};

    f(l);
    System.out.println(Arrays.toString(l));

	}

  static void f(Integer[] l) {
    l = new Integer[4];
  }
}