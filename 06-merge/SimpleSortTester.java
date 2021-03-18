import java.util.*;
import java.io.*;

public class SimpleSortTester {
  public static void main(String[] args) {
    int n = 50000000;

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = (int) (Math.random() * n);
    }

    int[] arr2 = arr.clone();

    Arrays.sort(arr);
    Merge.mergesort(arr2);

    boolean pass = true;
    for (int i = 0; i < n; i++) {
      if (arr[i] != arr2[i]) {
        pass = false;
        break;
      }
    }

    if (pass) {
      System.out.println("It's probably fine");
    }
    else {
      n = 2;
      boolean foundCase = false;

      while (!foundCase) {
        n *= 2;
        for (int test = 0; test < 3; test++) {
          arr = new int[n];
          for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * n);
          }
  
          arr2 = arr.clone();
          int[] arr3 = arr.clone();
  
          Arrays.sort(arr);
          Merge.mergesort(arr2);
  
          pass = true;
          for (int i = 0; i < n; i++) {
            if (arr[i] != arr2[i]) {
              pass = false;
              break;
            }
          }
  
          if (!pass) {
            System.out.println("Check this array:");
            System.out.println(Arrays.toString(arr3));
  
            System.out.println("\nThis is what your sort outputted:");
            System.out.println(Arrays.toString(arr2));
  
            System.out.println("\nHere's what it's supposed to output:");
            System.out.println(Arrays.toString(arr));
            foundCase = true;
            break;
          }
        }
      }
    }
  }  
}
