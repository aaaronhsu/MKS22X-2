import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {
    int n = 100000000;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = (int) (Math.random() * n);
      // arr[i] = n - i;
    }
    int[] test = arr.clone();

    // System.out.println(Quick.quickselect(arr, 4));

    long s = System.currentTimeMillis();
    Quick.quicksort(arr);

    System.out.println(System.currentTimeMillis() - s);

    s = System.currentTimeMillis();
    Arrays.sort(test);
    System.out.println(System.currentTimeMillis() - s);
    // System.out.println(Arrays.toString(arr));
  }
}
