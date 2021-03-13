import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {
    int n = 10000000;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = (int) (Math.random() * n);
      // arr[i] = n - i;
      // arr[i] = 1;
    }
    int[] test = arr.clone();

    // System.out.println(Quick.quickselect(arr, 4));

    long s = System.currentTimeMillis();
    Arrays.sort(arr);

    System.out.println(System.currentTimeMillis() - s);

    s = System.currentTimeMillis();
    Quick.quicksortDutch(test);
    System.out.println(System.currentTimeMillis() - s);
    // System.out.println(Arrays.toString(arr));

    // int[] arr = {3, 2, 7, 3, 3, 2};
    // int[] hold = Quick.partitionDutch(arr, 0, arr.length - 1);
    // System.out.println(Arrays.toString(arr));
    // System.out.println(Arrays.toString(hold));

    // int[] arr = {9, 8, 7, 6, 6, 6, 4, 2, 1};
    // int[] hold = Quick.partitionDutchBetter(arr, 0, arr.length - 1);
    // System.out.println(Arrays.toString(hold));

    // System.out.println(Arrays.toString(arr));
  }
}
