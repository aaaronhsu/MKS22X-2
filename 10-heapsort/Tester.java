import java.util.*;
import java.io.*;

public class Tester {
  public static void main(String[] args) {
    int[] arr = {3, 3, 3, 3, 1, 1, 2, 5, 6, 7, 7, 7, 8, 10};

    MyHeap.heapsort(arr);

    System.out.println(Arrays.toString(arr));
  }  
}
