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

    int[] merge = arr.clone();

    // System.out.println(Arrays.toString(merge));

    long time = System.currentTimeMillis();
    Merge.mergesort(arr);
    System.out.println(System.currentTimeMillis() - time);

    time = System.currentTimeMillis();    
    Merge.mergesort2(merge);
    System.out.println(System.currentTimeMillis() - time);

    // System.out.println(Arrays.toString(merge));

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != merge[i]) System.out.println("bad");
    }
  }  
}
