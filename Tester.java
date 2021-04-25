import java.util.*;
import java.io.*;

public class Tester {
  public static void main(String[] args) {
    int[] arr = {3, 2, 6};

    MyHeap.heapsort(arr);

    System.out.println(Arrays.toString(arr));
  }  
}
