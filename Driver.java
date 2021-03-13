import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {
    int n = 10000000;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = (int) (Math.random() * n);
      // arr[i] = n - i;
    }
    // int[] arr = {3, 7, 0, 6, 3, 1, 0, 3, 8, 4};
    int[] test = arr.clone();
    // System.out.println(Arrays.toString(test));

    // System.out.println(Quick.quickselect(arr, 4));

    long s = System.currentTimeMillis();
    Arrays.sort(arr);

    System.out.println(System.currentTimeMillis() - s);

    s = System.currentTimeMillis();
    Quick.quicksort(test);
    System.out.println(System.currentTimeMillis() - s);

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != test[i]) System.out.println("bad");
    }

    // System.out.println(Arrays.toString(arr));
    // System.out.println(Arrays.toString(test));

    // ----------------------------------------

    // int[] arr = {1, 1, 1, 1, 1};
    // int[] hold = Quick.partitionDutch(arr, 0, arr.length - 1);
    // System.out.println(Arrays.toString(arr));
    // System.out.println(Arrays.toString(hold));
  }
}
