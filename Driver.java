import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {
    int[] arr = {3, 6, 2, 7, 1, 8};

    System.out.println(Quick.quickselect(arr, 4));

    Quick.quicksort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
